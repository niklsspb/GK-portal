package ru.geekbrains.gkportal.config;



/*
//@Configuration
public class ConnectorConfig {

    @Bean
    public TomcatServletWebServerFactory containerFactory() {
        return new TomcatServletWebServerFactory() {
            protected void customizeConnector(Connector connector) {
                int maxSize = 50000000;
                super.customizeConnector(connector);
                connector.setMaxPostSize(maxSize);
                connector.setMaxSavePostSize(maxSize);
                if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {

                    ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
                    logger.info("Set MaxSwallowSize " + maxSize);
                }
            }
        };

    }


    private Connector redirectConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }
}
*/