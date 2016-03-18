package org.springframework.boot.autoconfigure.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDataSourceInitializer extends DataSourceInitializer {

    private static Log logger = LogFactory.getLog(DataSourceInitializer.class);

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    private DataSource dataSource;

    @Autowired
    private DataSourceProperties properties;

    private boolean initialized = false;

    @PostConstruct
    public void init() {
        if (!this.properties.isInitialize()) {
            logger.debug("Initialization disabled (not running DDL scripts)");
            return;
        }
        if (this.applicationContext.getBeanNamesForType(DataSource.class, false,
                false).length > 0) {
            this.dataSource = (DataSource) this.applicationContext.getBean("documents_master_dataSource");
        }
        if (this.dataSource == null) {
            logger.debug("No DataSource found so not initializing");
            return;
        }
        runSchemaScripts();
    }

    private void runSchemaScripts() {
        List<Resource> scripts = getScripts(this.properties.getSchema(), "schema");
        if (!scripts.isEmpty()) {
            runScripts(scripts);
            try {
                this.applicationContext
                        .publishEvent(new DataSourceInitializedEvent(this.dataSource));
                // The listener might not be registered yet, so don't rely on it.
                if (!this.initialized) {
                    runDataScripts();
                    this.initialized = true;
                }
            }
            catch (IllegalStateException ex) {
                logger.warn("Could not send event to complete DataSource initialization ("
                        + ex.getMessage() + ")");
            }
        }
    }

    @Override
    public void onApplicationEvent(DataSourceInitializedEvent event) {
        if (!this.properties.isInitialize()) {
            logger.debug("Initialization disabled (not running data scripts)");
            return;
        }
        // NOTE the event can happen more than once and
        // the event datasource is not used here
        if (!this.initialized) {
            runDataScripts();
            this.initialized = true;
        }
    }

    private void runDataScripts() {
        List<Resource> scripts = getScripts(this.properties.getData(), "data");
        runScripts(scripts);
    }

    private List<Resource> getScripts(String locations, String fallback) {
        if (locations == null) {
            String platform = this.properties.getPlatform();
            locations = "classpath*:" + fallback + "-" + platform + ".sql,";
            locations += "classpath*:" + fallback + ".sql";
        }
        return getResources(locations);
    }

    private List<Resource> getResources(String locations) {
        List<Resource> resources = new ArrayList<Resource>();
        for (String location : StringUtils.commaDelimitedListToStringArray(locations)) {
            try {
                for (Resource resource : this.applicationContext.getResources(location)) {
                    if (resource.exists()) {
                        resources.add(resource);
                    }
                }
            }
            catch (IOException ex) {
                throw new IllegalStateException(
                        "Unable to load resource from " + location, ex);
            }
        }
        return resources;
    }

    private void runScripts(List<Resource> resources) {
        if (resources.isEmpty()) {
            return;
        }
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(this.properties.isContinueOnError());
        populator.setSeparator(this.properties.getSeparator());
        if (this.properties.getSqlScriptEncoding() != null) {
            populator.setSqlScriptEncoding(this.properties.getSqlScriptEncoding().name());
        }
        for (Resource resource : resources) {
            populator.addScript(resource);
        }
        DatabasePopulatorUtils.execute(populator, this.dataSource);
    }

}



