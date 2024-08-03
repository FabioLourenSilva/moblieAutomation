package org.utils;

import Base.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static Base.DriveFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb() {
        Set<String> contextHandles = getDriver().getContextHandles();
        if (contextHandles.size() > 1) {
            for (String valor : contextHandles) {
                System.out.println(valor);
            }
            getDriver().context((String) contextHandles.toArray()[1]);
        } else {
            System.out.println("Não há contextos suficientes disponíveis.");
        }
    }

    public void switchToFlutterContext() {
        // Obtém todos os contextos disponíveis
        Set<String> contextHandles = getDriver().getContextHandles();

        // Imprime todos os contextos disponíveis
        System.out.println("Contextos disponíveis:");
        for (String context : contextHandles) {
            System.out.println(context);
        }

        // Procura e seleciona o contexto Flutter
        for (String context : contextHandles) {
            if (context.contains("flutter")) {
                getDriver().context(context);
                System.out.println("Mudou para o contexto Flutter: " + context);
                return;
            }
        }

        System.out.println("Contexto Flutter não encontrado.");
    }

    public void switchToWebViewContext() {
        Set<String> contextHandles = getDriver().getContextHandles();
        for (String context : contextHandles) {
            System.out.println("Contexto disponível: " + context);
            if (context.contains("WEBVIEW")) {
                getDriver().context(context);
                System.out.println("Mudado para o contexto WebView: " + context);
                break;
            }
        }
    }


    public void setEmail(String valor){
        getDriver().findElement(By.id("email")).sendKeys(valor);
    }

    public void sairContextoWeb(){
        getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }

    public static void switchContext(String context) {
        getDriver().getContext();
        Set<String> con = getDriver().getContextHandles();
        for (String c : con) {
            if (c.contains(context)) {
                getDriver().context(c);
                break;
            }
        }
   }

}