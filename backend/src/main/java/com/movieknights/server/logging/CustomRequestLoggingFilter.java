package com.movieknights.server.logging;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class CustomRequestLoggingFilter
        extends CommonsRequestLoggingFilter {

    public CustomRequestLoggingFilter() {
        super.setIncludeQueryString(true);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(10000);
    }


}
