package com.playmatch.mcpserver.config;

import com.playmatch.mcpserver.tools.BookingTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpServerConfig {

    @Bean
    public ToolCallbackProvider bookingToolsProvider(BookingTools bookingTools) {
        return MethodToolCallbackProvider.builder().toolObjects(bookingTools).build();
    }
}
