package Base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.List;
import static Base.DriveFactory.getDriver;
import static org.junit.Assert.assertEquals;

public class BasePage {


    public void escrever(By by, String texto){
        getDriver().findElement(by)
                .sendKeys(texto);
    }


    public void escreverChar(By by, String texto){
        getDriver().findElement(by).clear();
        MobileElement element = getDriver().findElement(by);
        for (char ch : texto.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            try {
                TimeUnit.NANOSECONDS.sleep(111);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//
//        String enteredText = element.getAttribute("value");
//        if (!enteredText.equals(texto)) {
//            element.clear();
//            escrever(by, texto);
//        }
    }



    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public void clicarId(By by){
        getDriver().findElement(by).click();
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(String id){
        getDriver().findElementById(id).click();
    }

    public void clickElementXpath(String xpath){
        getDriver().findElementById(String.valueOf(By.xpath(xpath))).click();
    }
    public void clicarEntrar(){
         getDriver().findElementByAccessibilityId("Entrar").click();
    }

    public void clicarPorTexto(String texto){
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void selecionarCombo(By by, String valor){
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public void vaidarConteudoAtributo(By by,String atributo ,String conteudo){
        MobileElement texto = getDriver().findElement(by);
        String textoAPP = String.valueOf(texto.getAttribute(atributo).equals(conteudo));
    }

    public void vaidarConteudo(By by,String conteudo){
        MobileElement texto = getDriver().findElement(by);
        String textoAPP = texto.getText();
        assertEquals(conteudo,textoAPP);
        System.out.println("Conteudo APP:     "+textoAPP);
        System.out.println("Conteudo esperado:"+conteudo);
    }

    public void validarConteudoID(String accessibilityId, String expectedText) {
        try {
            MobileElement element = getDriver().findElementByAccessibilityId(accessibilityId);
            String textoAPP = element.getText();
//            assertEquals(expectedText, textoAPP, "");
            assertEquals(expectedText,textoAPP);
            System.out.println("Conteúdo APP:     " + textoAPP);
            System.out.println("Conteúdo esperado: " + expectedText);
        } catch (Exception e) {
            System.err.println("Erro ao validar o conteúdo do elemento com ID " + accessibilityId + ": " + e.getMessage());
            throw e; // Relança a exceção para garantir que o teste falhe
        }
    }

    public void vaidarConteudoChar(By by,String conteudo){
        MobileElement element = getDriver().findElement(by);
        StringBuilder textoElemento = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            char charElemento = element.getText().charAt(i);
            textoElemento.append(charElemento);
            assertEquals(conteudo, textoElemento.toString());
        }
    }

    public boolean existeElementoPorTexto(String texto){
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
         return elementos.size() > 0;
    }

    public boolean existeElementoPorId(String texto){
        List<MobileElement> elementos = getDriver().findElements(MobileBy.AccessibilityId(texto));
        return elementos.size() > 0;
    }

    public String localizarElementoId (String acessibility){
        MobileElement elemento = getDriver().findElementByAccessibilityId(String.valueOf(acessibility));
        return acessibility;
    }

    public void clicarAcessib(String by){
        getDriver().findElementByAccessibilityId(by).click();
    }

    public void tap(int x, int y){
        TouchAction touchAction = new TouchAction<>(DriveFactory.getDriver());
        touchAction.tap(PointOption.point(x,y)).perform();
    }

    public void scrollDown(){
        scroll(0.9,0.1);
    }

    public void scrollUp(){
        scroll(0.1,0.9);
    }

    public void swipeLeft(){
        swipe(0.1,0.9);
    }
    public void swipeRight(){
        swipe(0.9,0.1);
    }

    public void scroll(double inicio, double fim){
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);
        new TouchAction(getDriver())
                .press(PointOption.point(x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x,end_y))
                .release()
                .perform();
    }

    public void swipe(double inicio, double fim){
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);
        new TouchAction(getDriver())
                .press(PointOption.point(start_x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x,y))
                .release()
                .perform();
    }

    public void swipeElement(MobileElement element, double inicio, double fim){

        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);
        new TouchAction(getDriver())
                .press(PointOption.point(start_x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x,y))
                .release()
                .perform();
    }

/*
Estrutura de espera explicita, adaptar para qualquer necessidade
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public void validarConteudoID(String accessibilityId, String expectedText) {
    try {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10); // espera de 10 segundos
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(accessibilityId)));
        String textoAPP = element.getText();
        assertEquals(expectedText, textoAPP, "O texto do elemento não corresponde ao esperado.");
        System.out.println("Conteúdo APP:     " + textoAPP);
        System.out.println("Conteúdo esperado: " + expectedText);
    } catch (Exception e) {
        System.err.println("Erro ao validar o conteúdo do elemento com ID " + accessibilityId + ": " + e.getMessage());
        throw e; // Relança a exceção para garantir que o teste falhe
    }
}
 */

    public String obterTituloAlerta(){
        return obterTexto(By.id("android:id/alertTitle"));
    }
    public String obterMensagemAlerta(){
        return obterTexto(By.id("android:id/message"));
    }
}
