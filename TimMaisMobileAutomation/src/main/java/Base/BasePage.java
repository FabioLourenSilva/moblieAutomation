package Base;

import Runner.RunTimMais;
import appium_flutter_driver.FlutterFinder;
import appium_flutter_driver.finder.FlutterElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.List;
import static Base.DriveFactory.getDriver;
import static org.junit.Assert.assertEquals;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
public class BasePage {

    WebDriverWait wait = new WebDriverWait(getDriver(), 240);

    FlutterFinder find = new FlutterFinder(getDriver());

    static String soRunner;
    static {
        RunTimMais runTimMais = new RunTimMais();
        soRunner = runTimMais.getSo();
    }


    // Funciton flutter by key

    private FlutterElement waitForVisibility(String value, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
        return wait.until(driver -> {
            FlutterElement element = find.byValueKey(value);
            return (element != null && element.isDisplayed()) ? element : null;
        });
    }

    private FlutterElement waitForClickability(String value, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
        return wait.until(driver -> {
            FlutterElement element = find.byValueKey(value);
            return (element != null && element.isEnabled() && element.isDisplayed()) ? element : null;
        });
    }
    public String findFlutterElement(String value, int time) {
        FlutterElement element = waitForVisibility(value, time);
        return element.getText();
    }

    public void escreverInFlutter(String value, String text, int time) {
        FlutterElement element = waitForVisibility(value, time);
        element.sendKeys(text);
    }

    public void clickFlutterElement(String value, int time) {
        FlutterElement element = waitForClickability(value, time);
        element.click();
    }

    // End integration function flutter



    public void escrever(By by, String texto){
        getDriver().findElement(by)
                .sendKeys(texto);
    }

    public void doubleCheckWrite(String xpath,String msisdn){
        MobileElement element = getDriver().findElement(By.xpath(xpath));
        String texto = element.getText();
        if (!texto.equals(element.getAttribute("value"))) {
            element.clear();
            escrever(By.xpath(xpath),msisdn);
        }
    }


    public void escreverChar(By by, String texto){
        MobileElement element = getDriver().findElement(by);
        element.clear();
        for (char ch : texto.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            try {
                if (soRunner.equals("android")) {
                    TimeUnit.MILLISECONDS.sleep(200);
                } else {
                    TimeUnit.MILLISECONDS.sleep(1);
                }
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
    public void clicarPorCoordenadas(int x, int y) {
        // Criar uma instância da classe Actions
        Actions actions = new Actions(getDriver());

        // Mover o cursor para as coordenadas especificadas e clicar
        actions.moveByOffset( x,  y).click().perform();
    }

    public void clicar(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 120);
        wait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
    }

    public void clickElement(String id){
        getDriver().findElementById(id).click();
    }

    public void clickElementXpath(String xpath){
        getDriver().findElementById(String.valueOf(By.xpath(xpath))).click();
    }
    public void clickElementid(String id){
        getDriver().findElementById(String.valueOf(MobileBy.id(id))).click();
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

    public void validarConteudo(By by,String conteudo){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
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
            assertEquals(expectedText,textoAPP);
        } catch (Exception e) {
            System.err.println("Erro ao validar o conteúdo do elemento com ID " + accessibilityId + ": " + e.getMessage());
            throw e;
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

    public void waitElement(By by, int time){
        WebDriverWait wait = new WebDriverWait(getDriver(),time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean existeElementoPorTexto(String texto){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + texto + "']")));
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
         return elementos.size() > 0;
    }

    public boolean existeElementoPorXpath(String texto){
        List<MobileElement> elementos = getDriver().findElements(By.xpath(texto));
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

    public String extractText(By by){
        MobileElement elemento = getDriver().findElement(by);
        String text = elemento.getText();
        return text;
    }

    public void clicarAcessib(String by){
        getDriver().findElementByAccessibilityId(by).click();
    }

    public void tap(int x, int y){
        TouchAction touchAction = new TouchAction<>(DriveFactory.getDriver());
        touchAction.tap(PointOption.point(x,y)).perform();
    }

    public void scrollDown(double x, double y ){
        scroll(x,y);
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

    public void scroll(double inicio, double fim) {
        // Obter o tamanho da tela
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width / 2; // Ponto médio horizontal
        int startY = (int) (size.height * inicio); // Ponto inicial vertical
        int endY = (int) (size.height * fim); // Ponto final vertical

        // Imprimir coordenadas para depuração
        System.out.println("Screen size: " + size);
        System.out.println("Start point: (" + x + ", " + startY + ")");
        System.out.println("End point: (" + x + ", " + endY + ")");

        // Criar e executar a ação de scroll
        new TouchAction<>(getDriver())
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    public void scrollMove() {

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
