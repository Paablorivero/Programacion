package com.decroly.vetapp;

import Utils.FileUtils;
import model.Consulta;
import model.Mascota;
import model.Propietario;
import model.SQLAcessVetDaw;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.net.URL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private ObservableList<Propietario> propietarios = FXCollections.observableArrayList();
    private ObservableList<Mascota> mascotas = FXCollections.observableArrayList();

    SQLAcessVetDaw miData = new SQLAcessVetDaw();


    @FXML
    private VBox pantallaPrincipal;

    @FXML
    private VBox RegistroMascota;

    @FXML
    private VBox RegistroPropietario;

    @FXML
    private VBox BusquedaMascota;

    @FXML
    private VBox RegistroConsulta;

    //Definimos textField para el registro de mascotas

    @FXML
    private TextField MascotaPasaporte;

    @FXML
    private TextField MascotaNombre;

    @FXML
    private TextField MascotaPeso;

    @FXML
    private TextField MascotaFNacimiento;

    @FXML
    private TextField MascotaTipo;

    @FXML
    private ListView<Propietario> MascotaPropietario;

    //Definimos textField para el registro de propietario

    @FXML
    private TextField PropietarioNombre;

    @FXML
    private TextField PropietarioApellido;

    @FXML
    private TextField PropietarioDni;

    @FXML
    private TextField PropietarioTelefono;

    @FXML
    private TextField PropietarioDireccion;

    @FXML
    private TextField PropietarioEmail;

    //Definimos textField para el registro de una consulta
    @FXML
    private TextField ConsultaFecha;

    @FXML
    private TextField ConsultaDuracion;

    @FXML
    private TextField ConsultaObservaciones;

    @FXML
    private ListView<Mascota> ConsultaMascota;


    //Definimos textField para la busqueda de mascotas
    @FXML
    private TextField BuscarMascota;

    @FXML
    private ListView<Mascota> ResultadoBusqueda;



    //Botones pantalla principal
    @FXML
    protected void onAccederRegistrarMacota(ActionEvent event) {
        //Ir al panel de registro
        selectPanelVisible(1);
        this.clearFieldsMascota();
    }

    @FXML
    protected void onAccederRegistrarPropietario(ActionEvent event) {
        //Ir al panel de registro
        selectPanelVisible(2);
        this.clearFieldsPropietario();
    }

    @FXML
    protected void onAccederRegistrarConsulta(ActionEvent event) {
        //Ir al panel de registro
        selectPanelVisible(4);
        this.clearFieldsPropietario();
    }

    @FXML
    protected void onAccederBuscarMascota(ActionEvent event) {
        //Ir al panel de registro
        selectPanelVisible(3);
        this.clearFieldsPropietario();
    }

    @FXML
    protected void onSalirApp(ActionEvent event) {
        Platform.exit();
    }

    //Botones registro de mascota
    @FXML
    protected void onBotonGuardarMascota(ActionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(MascotaFNacimiento.getText(), formatter);
        Mascota m = new Mascota(
                MascotaPasaporte.getText(),
                MascotaNombre.getText(),
                fechaNacimiento,
                Double.parseDouble(MascotaPeso.getText()),
                MascotaTipo.getText(),
                MascotaPropietario.getSelectionModel().getSelectedItem()
        );

        //Ir al inicio
        selectPanelVisible(0);
        int response = miData.insertMascota(m);
    }

    @FXML
    protected void onBotonVolverRegistroMascota(ActionEvent event) {
        //Ir al panel de registro
        selectPanelVisible(0);
        this.clearFieldsMascota();
    }

    //Botones Menu registro propietario
    @FXML
    protected void onBotonGuardarPropietario(ActionEvent event) {

        Propietario p = new Propietario(
            PropietarioNombre.getText(),
            PropietarioApellido.getText(),
            PropietarioDni.getText(),
            PropietarioTelefono.getText(),
            PropietarioDireccion.getText(),
            PropietarioEmail.getText()
        );

        //Ir al inicio
        selectPanelVisible(0);

        int response = miData.insertPropietario(p);
        MascotaPropietario = null;
        List<Propietario> propietarioSQL = SQLAcessVetDaw.getPropietarios();
        propietarios.addAll(propietarioSQL);
        MascotaPropietario.setItems(propietarios);
    }

    @FXML
    protected void onBotonVolverRegistroPropietario(ActionEvent event) {
        //Ir al panel de registro
        selectPanelVisible(0);
        this.clearFieldsPropietario();
    }

    //Botones menu registro consulta

    @FXML
    protected void onBotonGuardarConsulta(ActionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaConsulta = LocalDate.parse(ConsultaFecha.getText(), formatter);
        Consulta m = new Consulta(
                fechaConsulta,
                Integer.parseInt(ConsultaDuracion.getText()),
                ConsultaObservaciones.getText(),
                ConsultaMascota.getSelectionModel().getSelectedItem()
        );

        //Ir al inicio
        selectPanelVisible(0);
        int response = miData.insertConsulta(m);

    }

    @FXML
    protected void onBotonVolverRegistroConsulta(ActionEvent event) {
        selectPanelVisible(0);
        clearFieldsConsulta();
    }



    //Botones menu busqueda
    @FXML
    protected void onBuscarMascota(ActionEvent event) {
        List<Mascota> mascotaSQLBusqueda = SQLAcessVetDaw.BuscarMascota(BuscarMascota.getText());
        mascotas.addAll(mascotaSQLBusqueda);
        ResultadoBusqueda.setItems(mascotas);
    }

    @FXML
    protected void onVolverBuscar(ActionEvent event) {
        selectPanelVisible(0);
        clearFieldsBusqueda();
    }


    //Exportamos datos de las mascotas
    @FXML
    protected void onExportarDatos(ActionEvent event){
        FileUtils.writeFile("ExportDatos.dat",new LinkedList<>(mascotas));
    }


    //Metodo initialize que se ejecuta al iniciarse el MainController
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pantallaPrincipal.setVisible(true);
        RegistroMascota.setVisible(false);
        RegistroPropietario.setVisible(false);
        BusquedaMascota.setVisible(false);
        RegistroConsulta.setVisible(false);


        //Prompt registro mascota
        MascotaPasaporte.setPromptText("Pasaporte");
        MascotaNombre.setPromptText("Nombre");
        MascotaPeso.setPromptText("Peso");
        MascotaFNacimiento.setPromptText("Fecha de nacimiento");
        MascotaTipo.setPromptText("Tipo 1-10");

        PropietarioNombre.setPromptText("Nombre");
        PropietarioApellido.setPromptText("Apellido");
        PropietarioDni.setPromptText("DNI");
        PropietarioTelefono.setPromptText("Telefono");
        PropietarioDireccion.setPromptText("Direccion");
        PropietarioEmail.setPromptText("Email");

        BuscarMascota.setPromptText("Buscar Mascota");



        List<Propietario> propietarioSQL = SQLAcessVetDaw.getPropietarios();
        propietarios.addAll(propietarioSQL);
        MascotaPropietario.setItems(propietarios);

        List<Mascota> mascotasSQL = SQLAcessVetDaw.getMascotas();
      mascotas.addAll(mascotasSQL);
       ConsultaMascota.setItems(mascotas);


        MascotaNombre.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateName(MascotaNombre.getText())){
                    MascotaNombre.setText("");
                    MascotaNombre.setPromptText("Valor incorrecto");
                }
            }
        });



        PropietarioNombre.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateName(PropietarioNombre.getText())){
                    PropietarioNombre.setText("");
                    PropietarioNombre.setPromptText("Valor incorrecto");
                }
            }
        });

        PropietarioApellido.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateName(PropietarioApellido.getText())){
                    PropietarioApellido.setText("");
                    PropietarioApellido.setPromptText("Valor incorrecto");
                }
            }
        });

        PropietarioDni.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateDni(PropietarioDni.getText())){
                    PropietarioDni.setText("");
                    PropietarioDni.setPromptText("Valor incorrecto");
                }
            }
        });

        PropietarioTelefono.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validatePhone(PropietarioTelefono.getText())){
                    PropietarioTelefono.setText("");
                    PropietarioTelefono.setPromptText("Valor incorrecto");
                }
            }
        });

        PropietarioEmail.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validateEmail(PropietarioEmail.getText())){
                    PropietarioEmail.setText("");
                    PropietarioEmail.setPromptText("Valor incorrecto");
                }
            }
        });



        MascotaPasaporte.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!validatePasaporte(MascotaPasaporte.getText())){
                    MascotaPasaporte.setText("");
                    MascotaPasaporte.setPromptText("Valor incorrecto");
                }
            }
        });
    }//metodo initialize


    private void clearFieldsMascota() {
        MascotaPasaporte.setText("");
        MascotaNombre.setText("");
        MascotaPeso.setText("");
        MascotaFNacimiento.setText("");
        MascotaTipo.setText("");
    }

    private void clearFieldsPropietario() {
        PropietarioNombre.setText("");
        PropietarioApellido.setText("");
        PropietarioDni.setText("");
        PropietarioTelefono.setText("");
        PropietarioDireccion.setText("");
        PropietarioEmail.setText("");
    }

    private void clearFieldsConsulta() {
        ConsultaFecha.setText("");
        ConsultaDuracion.setText("");
        ConsultaObservaciones.setText("");
    }

    private void clearFieldsBusqueda() {
        BuscarMascota.setText("");
    }


    private void selectPanelVisible(int i) {
        switch (i) {

            case 0:
                pantallaPrincipal.setVisible(true);
                RegistroMascota.setVisible(false);
                RegistroPropietario.setVisible(false);
                BusquedaMascota.setVisible(false);
                RegistroConsulta.setVisible(false);
                break;

            case 1:
                pantallaPrincipal.setVisible(false);
                RegistroMascota.setVisible(true);
                RegistroPropietario.setVisible(false);
                BusquedaMascota.setVisible(false);
                RegistroConsulta.setVisible(false);
                break;

            case 2:
                pantallaPrincipal.setVisible(false);
                RegistroMascota.setVisible(false);
                RegistroPropietario.setVisible(true);
                BusquedaMascota.setVisible(false);
                RegistroConsulta.setVisible(false);
                break;

            case 3:
                pantallaPrincipal.setVisible(false);
                RegistroMascota.setVisible(false);
                RegistroPropietario.setVisible(false);
                BusquedaMascota.setVisible(true);
                RegistroConsulta.setVisible(false);
                break;

            case 4:
                pantallaPrincipal.setVisible(false);
                RegistroMascota.setVisible(false);
                RegistroPropietario.setVisible(false);
                BusquedaMascota.setVisible(false);
                RegistroConsulta.setVisible(true);
                break;

            default:
                pantallaPrincipal.setVisible(true);
                RegistroMascota.setVisible(false);
                RegistroPropietario.setVisible(false);
                BusquedaMascota.setVisible(false);
                RegistroConsulta.setVisible(false);
        }
    }


    private boolean validateName(String name){
        return (name.length() > 3 && name.matches("[A-Z]{1}[a-z]{2,25}"));
    }

    private boolean validatePhone(String phone){
        return phone.matches("[1-9]{9}");
    }

    private boolean validateEmail(String email){
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailPattern);
    }

    private boolean validateAge(String age){
        return age.matches("[1-9]{1,3}");
    }

    private boolean validateDni(String dni){
        return dni.matches("[0-9]{7,8}[A-Z a-z]");
    }

    private boolean validatePasaporte(String passport){
        return passport.matches("P[0-9]{9}");
    }
}