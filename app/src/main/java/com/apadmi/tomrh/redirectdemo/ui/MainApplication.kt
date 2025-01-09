package com.apadmi.tomrh.redirectdemo.ui

import android.app.Application
import com.apadmi.mockzilla.lib.models.EndpointConfiguration
import com.apadmi.mockzilla.lib.models.MockzillaConfig
import com.apadmi.mockzilla.lib.models.MockzillaHttpResponse
import com.apadmi.mockzilla.lib.startMockzilla

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val dummyWebpageSource = "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Dummy Webpage</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<button onclick='window.location.href=\"redirect-demo://app/\";'>\n" +
                "    <h3>Launch deep-link</h3>\n" +
                "</button>\n" +
                "</body>\n" +
                "</html>"
        val mockzillaConfig = MockzillaConfig.Builder()
            .setPort(8080)
            .addEndpoint(
                EndpointConfiguration
                    .Builder("Dummy web page")
                    .setPatternMatcher { uri.endsWith("/dummy-page") }
                    .setDefaultHandler {
                        MockzillaHttpResponse(
                            headers = mapOf(
                                "Content-type" to "text/html"
                            ),
                            body = dummyWebpageSource
                        )
                    }
            ).build()
        startMockzilla(mockzillaConfig, this)
    }
}