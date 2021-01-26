/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientbase;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pogliani.mattia
 */
public class ClientBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Apertua connessione");
        try {
            while (true) {

                Socket server = new Socket("127.0.0.1", 6666);
                InputStream dalServer = server.getInputStream();
                BufferedReader lettore = new BufferedReader(
                        new InputStreamReader(dalServer));

                String risposta = lettore.readLine();
                System.out.println("risposta del server: " + risposta);

                lettore.close();
                server.close();
                System.out.println("chiusura connessione");
                Thread.sleep(5000);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException e) {

        }
    }

}
