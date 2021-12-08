package fm.vane.spb1.demo1.controllers;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fm.vane.spb1.demo1.model.Mensualidad;

/**
 * See redirections guide at:
 * https://www.baeldung.com/spring-redirect-and-forward
 */
@Controller
public class DashboardController {

    private ArrayList<String> placas = new ArrayList<String>();
    private ArrayList<Mensualidad> mensualidades = new ArrayList<Mensualidad>(); 
    
    private int cantidadCeldas = 50;
    private String claveAdministrador = "1234";



    private static final String ERROR_INGRESAR_VEHICULO_PLACA_VACIA = "Ingreso Vehiculo/// La placa del Vehiculo no puede ser vacia";
    private static final String ERROR_INGRESAR_VEHICULO_PLACA_IVALIDA = "Ingreso Vehiculo/// La placa del Vehiculo es invalida";
    private static final String EXITO_INGRESAR_VEHICULO = "La placa fue ingresada con Exito";

    private static final String EXITO_SALIDA_VEHICULO = "Se ha eliminado placa del vehiculo Exitosamente";

    @GetMapping(value = { "/dashboard" })
    public String pagPrincipal(
            Model model,
            @RequestParam(defaultValue = "emptyTitle", required = false) String title,
            @RequestParam(defaultValue = "alert0", required = false) String messageType) {

        // logicio de nogocio

        // definies valores a ser remplazados

        model.addAttribute("result", title);
        model.addAttribute("color", messageType);
        model.addAttribute("_placas_", placas);
        
        return "dash";
    }

    @GetMapping(value = { "/ingresovehiculo" })
    public RedirectView ingresovehiculo(
            RedirectAttributes redirectAttributes, // atributosParaLaUrlALaQueSeVaARedireccionar
            @RequestParam(defaultValue = "", required = false) String placa // Parametro default queda en blanco, para
                                                                            // poder realizar las validaciones de las if
    ) {
        if (placa.isBlank()) {
            configuarURLError(ERROR_INGRESAR_VEHICULO_PLACA_VACIA, redirectAttributes);
        } else if (placa.length() < 6 || placa.length() > 7) {
            configuarURLError(ERROR_INGRESAR_VEHICULO_PLACA_IVALIDA, redirectAttributes);
        } else {
            placas.add(placa);
            System.out.print(placas);
            configuarURLExito(EXITO_INGRESAR_VEHICULO, redirectAttributes);
        }
        return new RedirectView("/dashboard");
    }

    @GetMapping(value = { "/salidavehiculo" })
    public RedirectView salidavehiculo(
            RedirectAttributes attributes,
            @RequestParam(defaultValue = "", required = false) String placa) {
        placas.remove(placa);
        configuarURLExito(EXITO_SALIDA_VEHICULO + placa, attributes);
        return new RedirectView("/dashboard");
    }

    @GetMapping(value = { "/ingresarmensualidad" })
    public RedirectView registromensualidad(
            RedirectAttributes attributes,
            @RequestParam(defaultValue = "fff", required = false) String placa,
            @RequestParam(defaultValue = "0", required = false) int dias) {

                if (placa.isBlank()) {
                    configuarURLError(ERROR_INGRESAR_VEHICULO_PLACA_VACIA, attributes);
                } else if (placa.length() < 6 || placa.length() > 7) {
                    configuarURLError(ERROR_INGRESAR_VEHICULO_PLACA_IVALIDA, attributes);
                } else {
                    this.placas.add(placa);
                    System.out.print(placas);
                    configuarURLExito(EXITO_INGRESAR_VEHICULO, attributes);
                } 
        Mensualidad m1 = new Mensualidad(placa,dias);
        // mensualidades.add( m1);

        mensualidades.add( m1 );

        attributes.addAttribute("title", "mensualidad aceptada para " + m1.placa );
        attributes.addAttribute("messageType", "Alert1");
        return new RedirectView("/dashboard");
    }

    @GetMapping(value = { "/configuracioncelda" })
    public RedirectView configuracioncelda(
            RedirectAttributes attributes,
            @RequestParam(defaultValue = "0", required = false) int p_cantidadCeldas) {

        //1.Logica de negocio
        this.cantidadCeldas = p_cantidadCeldas;


        //2. configuro la redireccion 
        configuarURLExito("cantidad de celdas " + cantidadCeldas, attributes);
    

        //3. retorno la redireccion
        return new RedirectView("/dashboard");
    }

    @GetMapping(value = { "/action1" })
    public RedirectView action1(
            RedirectAttributes attributes,
            @RequestParam(defaultValue = "fff", required = false) String fname,
            @RequestParam(defaultValue = "lll", required = false) String lname) {
        attributes.addAttribute("title", "action1 executed for " + fname + lname);
        attributes.addAttribute("messageType", "Alert0");
        return new RedirectView("/dashboard");
    }

    @GetMapping(value = { "/agregarpropietario" })
    public RedirectView action2(
            RedirectAttributes attributes,
            @RequestParam(defaultValue = "", required = false) String propcc) {
        if (propcc.isBlank()) {
            attributes.addAttribute("title", "Agregar porpietario /// La cedula del propietario no puede ser vacia");
            attributes.addAttribute("messageType", "red");
        } else if (propcc.length() < 6 || propcc.length() > 21) {
            attributes.addAttribute("title", "Cantidad - Cedula es invalida");
            attributes.addAttribute("messageType", "red");
        } else if (!itsarealccnumber(propcc)) {
            attributes.addAttribute("title", "No es un numbero - Cedula es invalida");
            attributes.addAttribute("messageType", "red");
        } else {
            attributes.addAttribute("title", "La cedula del propietario fue ingresada con exito");
            attributes.addAttribute("messageType", "green");
        }
        return new RedirectView("/dashboard");
    }

    /**
     * 
     * @param propcc
     * @return verdadero si pudes parsear una cedula desde el texto
     */
    private boolean itsarealccnumber(String propcc) {
        System.out.println("parseando[" + propcc + "]");
        try {
            int resultado = Integer.parseInt(propcc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void configuarURL(String mensaje, String tipo, RedirectAttributes attributesp) {
        attributesp.addAttribute("title", mensaje);
        attributesp.addAttribute("messageType", tipo);
    }

    // green, alert, error, info (blanco o azul)

    private void configuarURLExito(String mensaje, RedirectAttributes attributesp) {
        attributesp.addAttribute("title", mensaje);
        attributesp.addAttribute("messageType", "green");
    }

    private void configuarURLError(String mensaje, RedirectAttributes attributesp) {
        attributesp.addAttribute("title", mensaje);
        attributesp.addAttribute("messageType", "red");
    }

}