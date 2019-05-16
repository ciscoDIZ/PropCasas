package com.ciscodiz.propietarios_maven.controlador;


import com.ciscodiz.propietarios_maven.modelo.Casa;
import com.ciscodiz.propietarios_maven.modelo.Propietario;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    ArrayList<Propietario> propietarios;
    ArrayList<Casa> casas;
    Propietario propApunt;
    Casa casaApunt;
    Casa casaPropApunt;

    @FXML
    private Label lblModificar;
    @FXML
    private TextField txtIDPropietario;
    @FXML
    private TextField txtNombreProp;
    @FXML
    private TextField txtApellidoProp;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnPropAtras;
    @FXML
    private Button btnPropAlante;
    @FXML
    private Button btnPropAgregar;
    @FXML
    private Button btnPropEliminar;
    @FXML
    private Button btnPropCasasAtras;
    @FXML
    private Button btnPropCasasAlante;
    @FXML
    private Button btnPropCasasAgregar;
    @FXML
    private Button btnPropCasasEliminar;
    @FXML
    private TextField txtIdPropCasas;
    @FXML
    private TextField txtMetrosCasasProp;
    @FXML
    private Button btnPropCasasOK;
    @FXML
    private Button btnPropCasasCanelar;
    @FXML
    private Button btnPropOk;
    @FXML
    private Button btnPropCancelar;
    @FXML
    private Button btnCasasAtras;
    @FXML
    private Button btnCasasAgregar;
    @FXML
    private Button btnCasasEliminar;
    @FXML
    private RadioButton rbtPropCasaCas;
    @FXML
    private ToggleGroup CasaPiso;
    @FXML
    private RadioButton rbtPropCasaPiso;
    @FXML
    private TextField txtNumeroCasasProp;
    @FXML
    private TextField txtPlantaCasasProp;
    @FXML
    private Button BtnPropDniComprobar;
    @FXML
    private TextField txtPropEdad;
    @FXML
    private Button btnCasasAlante;
    @FXML
    private TextField txtIdCasas;
    @FXML
    private TextField txtMetrosCasas;
    @FXML
    private Button btnCasasOK;
    @FXML
    private Button btnCasasCanelar;
    @FXML
    private RadioButton rbtCasaCas;
    @FXML
    private ToggleGroup CasaPiso1;
    @FXML
    private RadioButton rbtCasaPiso;
    @FXML
    private TextField txtNumeroCasas;
    @FXML
    private TextField txtPlantaCasas;
    @FXML
    private TextField txtnombreCasasProp;
    @FXML
    private TextField txtNombreCasas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblModificar.setVisible(false);
        this.btnPropOk.setVisible(false);
        this.btnPropCancelar.setVisible(false);
        propietarios = new ArrayList<>();
        casas = new ArrayList<>();
        this.casaApunt = null;
        this.propApunt = null;
        this.casaPropApunt = null;
        this.txtPlantaCasas.setEditable(false);
        this.txtPlantaCasas.setText("Opción exclusiva de pisos");
        this.btnCasasOK.setVisible(false);
        this.btnCasasCanelar.setVisible(false);
        this.btnPropCasasOK.setVisible(false);
        this.btnPropCasasCanelar.setVisible(false);
    }

    @FXML
    private void btnPropAtrasOnClick(MouseEvent event) {
        if (propietarios.size() > 1 && propApunt != null) {
            for (int i = 0; i < propietarios.size(); i++) {
                Propietario p = propietarios.get(i);
                if (p.equals(propApunt) && i - 1 < 0) {
                    p = propietarios.get(i - 1);
                    propApunt = p;
                    setPropietarioApuntador(p);
                }
            }
        }
    }

    private void setPropietarioApuntador(Propietario p) {
        this.txtApellidoProp.setText(p.getApellido1() + " " + p.getApellido2());
        this.txtIDPropietario.setText(p.getDni().toString());
        this.txtNombreProp.setText(p.getNombre());
        this.txtPropEdad.setText(String.valueOf(p.getEdad()));
        if (p.getCasasLista().size() > 0) {
            Casa c = propApunt.getCasasLista().get(0);
            setPropCasasApuntador(c);
        }
    }

    @FXML
    private void btnPropAdelanteOnClick(MouseEvent event) {
        if (propietarios.size() > 1 && propApunt != null) {
            for (int i = 0; i < propietarios.size(); i++) {
                Propietario p = propietarios.get(i);
                if (p.equals(propApunt) && i + 1 >= propietarios.size()) {
                    p = propietarios.get(i + 1);
                    propApunt = p;
                    setPropietarioApuntador(p);
                }
            }
        }
    }

    private void btnPropEliminarOnClick(MouseEvent event) {
        if (propApunt != null) {
            Propietario p = propApunt;
            if (propietarios.size() > 1) {
                btnPropAtrasOnClick((MouseEvent) event);
            } else {
                this.txtApellidoProp.setText(" ");
                this.txtIDPropietario.setText("");
                this.txtNombreProp.setText("");
                this.txtPropEdad.setText("");
                casaPropApunt = null;
                this.txtIdPropCasas.setText("");
                this.txtnombreCasasProp.setText("");
                this.txtMetrosCasasProp.setText("");
                this.txtNumeroCasasProp.setText("");
                this.txtPlantaCasasProp.setText("");
            }
            propietarios.remove(p);
        }
    }

    @FXML
    private void btnPropCasasAtrasOnClick(MouseEvent event) {
        if (propApunt.getCasasLista().size() > 1 && propApunt != null && casaPropApunt != null) {
            for (int i = 0; i < propApunt.getCasasLista().size(); i++) {
                Casa c = propApunt.getCasasLista().get(i);
                if (c.equals(casaPropApunt) && i - 1 < 0) {
                    c = propApunt.getCasasLista().get(i - 1);
                    casaPropApunt = c;
                    setPropCasasApuntador(c);
                }
            }
        }
    }

    @FXML
    private void btnPropCasasAdelanteOnClick(MouseEvent event) {
        if (propApunt.getCasasLista().size() > 1 && propApunt != null && casaPropApunt != null) {
            for (int i = 0; i < propApunt.getCasasLista().size(); i++) {
                Casa c = propApunt.getCasasLista().get(i);
                if (c.equals(casaPropApunt) && i + 1 >= propApunt.getCasasLista().size()) {
                    c = propApunt.getCasasLista().get(i + 1);
                    casaPropApunt = c;
                    setPropCasasApuntador(c);
                }
            }
        }
    }

    private void setPropCasasApuntador(Casa c) {
        this.txtIdPropCasas.setText(c.getIdCasaInstance() + "");
        this.txtnombreCasasProp.setText(c.getVia());
        this.txtMetrosCasasProp.setText(c.getMetrosCuadrados() + "");
        this.txtNumeroCasasProp.setText(c.getNumero() + "");
        if (c.getPlanta() != null) {
            this.txtPlantaCasasProp.setText(String.valueOf(c.getPlanta()));
        }
    }

    @FXML
    private void btnPropCasasAgregarOnClick(MouseEvent event) {
    }

    @FXML
    private void btnPropCasasEliminarOnClick(MouseEvent event) {
        if (casaPropApunt != null) {
            Casa c = casaPropApunt;
            if (propApunt.getCasasLista().size() > 1) {
                btnCasasAtrasOnClick(event);
            } else {
                this.txtIdCasas.setText("");
                this.txtNombreCasas.setText("");
                this.txtMetrosCasas.setText("");
                this.txtNumeroCasas.setText("");
                this.txtPlantaCasas.setText("");
            }
            btnPropCasasAtrasOnClick(event);
            propApunt.getCasasLista().remove(c);

        }
    }

    @FXML
    private void btnPropCasasOkOnClick(MouseEvent event) {
    }

    @FXML
    private void btnPropCasasCancelarOnClick(MouseEvent event) {
    }

    @FXML
    private void btnPropOkOnClick(MouseEvent event) {
        if (this.propApunt != null) {

        }
    }

    @FXML
    private void radiobuttonCasaOnClick(MouseEvent event) {
        this.txtPlantaCasas.setEditable(false);
        this.txtPlantaCasas.setText("Opción exclusiva de pisos");
    }

    @FXML
    private void radiobuttonPisoOnClick(MouseEvent event) {
        this.txtPlantaCasas.setEditable(true);
        this.txtPlantaCasas.setText("");
    }

    @FXML
    private void btnCasasAtrasOnClick(MouseEvent event) {
        if (casas.size() > 1 && casas != null) {
            for (int i = 0; i < casas.size(); i++) {
                Casa c = casas.get(i);
                if (c.equals(casas) && i - 1 < 0) {
                    c = casas.get(i - 1);
                    casaApunt = c;
                    setCasasApuntador(c);
                }
            }
        }
    }

    private void setCasasApuntador(Casa c) {
        this.txtIdCasas.setText(c.getIdCasaInstance() + "");
        this.txtNombreCasas.setText(c.getVia());
        this.txtMetrosCasas.setText(c.getMetrosCuadrados() + "");
        this.txtNumeroCasas.setText(c.getNumero() + "");
        if (c.getPlanta() != null) {
            this.txtPlantaCasas.setText(String.valueOf(c.getPlanta()));
        }
    }

    @FXML
    private void btnCasasAdelanteOnClick(MouseEvent event) {
        if (casas.size() > 1 && casas != null) {
            for (int i = 0; i < casas.size(); i++) {
                Casa c = casas.get(i);
                if (c.equals(casas) && i + 1 >= casas.size()) {
                    c = casas.get(i + 1);
                    casaApunt = c;
                    setCasasApuntador(c);
                }
            }
        }
    }

    @FXML
    private void btnCasasAgregarOnClick(MouseEvent event) {
    }

    @FXML
    private void btnCasasEliminarOnClick(MouseEvent event) {
        if (casaApunt != null) {
            Casa c = new Casa(casaApunt);
            if (casas.size() > 1) {
                btnCasasAtrasOnClick(event);
            } else {
                this.txtIdCasas.setText("");
                this.txtNombreCasas.setText("");
                this.txtMetrosCasas.setText("");
                this.txtNumeroCasas.setText("");
                this.txtPlantaCasas.setText("");
            }
            int remove=0;
            for (int i = 0; i < casas.size(); i++) {
                if(casas.get(i).getIdCasaInstance()==c.getIdCasaInstance()){
                    remove=i;
                }
                
            }
            casas.remove(remove); 
            

        }
    }
    

    @FXML
    private void radiobuttonPropCasaOnClick(MouseEvent event) {
        this.txtPlantaCasasProp.setEditable(false);
        this.txtPlantaCasasProp.setText("Opción exclusiva de pisos");
    }

    @FXML
    private void radiobuttonPropPisoOnClick(MouseEvent event) {
        this.txtPlantaCasasProp.setEditable(true);
        this.txtPlantaCasasProp.setText("");
    }

    @FXML
    private void btnModifPropOnclick(MouseEvent event) {
    }

    @FXML
    private void btnPropAgregarOnClick(ContextMenuEvent event) {
    }

    @FXML
    private void btnPropEliminarOnClick(ContextMenuEvent event) {
    }
}
