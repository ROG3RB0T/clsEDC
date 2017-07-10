/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package archivoEDC;
import java.io.*;

/**
 *
 * @author roger
 */
public class leerEDC {

    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;

    public leerEDC(){}

    public void cargarNCR(String edc)
    {
        String[] separador = new String[]
          {
            "       ",//En archivo NCR elimina 7 espacios entre fecha y hora
            "F\\.",
            "T\\:",
            "MONTO",
            "F CONT ",
            "SALDO\\:",
            "DISPONIBLE",
            "CUENTA DE AHORRO\\:",
            "CUENTA DE AHORRO\\:",
            "CUENTA CORRIENTE\\:",
            "CUENTA CORRIENTE\\:",
            "DE\\:",
            "BILLETES\\:",
            "\\$"
        };
        try{
           this.archivo = new File(edc);
           fr = new FileReader(archivo);
           br = new BufferedReader(fr);

           String linea;
           String[] tx;

           while((linea = br.readLine())!= null){
                tx = this.arraySpliter(linea, separador);
                if(tx != null){
                    int j = 0;
                    for(int i = 0;i<tx.length;i++){
                        System.out.print("[" + j + "]" + tx[i].trim().toString() + "\n");
                        j++;
                    }
                }
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{

                if(null != fr){
                    fr.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void cargarDiebold(String edc)
    {
        String[] separador = new String[]
        {"a","d","e:","e;","e1","e2","e3","e4","e5",
         "e6","e7","e8","e9","F\\.","TARJETA\\:","FECHA CONTABLE ","\\$"};
        try{
           this.archivo = new File(edc);
           fr = new FileReader(archivo);
           br = new BufferedReader(fr);

           String linea;
           String[] tx;

           while((linea = br.readLine())!= null){
                tx = this.arraySpliter(linea, separador);
                if(tx != null){
                    int j = 0;
                    for(int i = 0;i<tx.length;i++){
                        System.out.print("[" + j + "]" + tx[i].trim().toString() + "\n");
                        j++;
                    }
                }
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{

                if(null != fr){
                    fr.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private String[] arraySpliter(String cadena, String[] separador)
    {
        String[] resultado;

        for(int i = 0;i<separador.length;i++)
        {
            cadena = cadena.replaceAll(separador[i],"\\|").toString().trim();

        }
            resultado = cadena.split("\\|");
       return resultado;
   }
}
   

