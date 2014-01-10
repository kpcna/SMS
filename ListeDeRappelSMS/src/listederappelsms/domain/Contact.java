/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listederappelsms.domain;

/**
 *
 * @author kpcna
 */
public class Contact {
    private String Nom;
    private String Prenom;
    private String PosteOccupe;
    private String NumCell;

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getPosteOccupe() {
        return PosteOccupe;
    }

    public void setPosteOccupe(String PosteOccupe) {
        this.PosteOccupe = PosteOccupe;
    }

    public String getNumCell() {
        return NumCell;
    }

    public void setNumCell(String NumCell) {
        this.NumCell = NumCell;
    }

}
