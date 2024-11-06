package com.automationTests.pages;

import com.automationTests.utilities.Driver;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public abstract class LoadingPageFactory {

    protected Actions action;

    public LoadingPageFactory(){
        this.action = new Actions(Driver.get());
        PageFactory.initElements(Driver.get(),this);
    }

    public void waitUntilPageLoadingIsFinished(int timeoutSeconds) {
        try {
            await().atMost(10, TimeUnit.SECONDS)
                    .pollInterval(1, TimeUnit.SECONDS)
                    .until(() -> getPageLoadingElement() == null);
        } catch (ConditionTimeoutException e) {
            throw new RuntimeException("Page did not load in " + timeoutSeconds + " seconds.", e);
        }
    }

    private Object getPageLoadingElement() {
        return null;
    }
}
