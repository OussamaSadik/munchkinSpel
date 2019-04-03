package exceptions;

public class maximaalAantalAfgelegdeKaartenBereikt extends Exception {

    public maximaalAantalAfgelegdeKaartenBereikt() {
        super("Deze kaart mag niet gespeeld worden !\nZie regels:\nSpeler kan maar maximaal 1 ras hebben \n" +
                "o Maximaal aantal uitrustingskaarten afgelegd:\n ● 1 Helm \n● 1 Vest\n ● 1 Paar schoenen\n ● 2 Wapens (of 3 indien de speler ook Dwerg is als ras) ");

    }


    public maximaalAantalAfgelegdeKaartenBereikt(String msg) {
        super(msg);
    }

    public maximaalAantalAfgelegdeKaartenBereikt(String message, Throwable cause){
        super(message,cause);
    }

    public maximaalAantalAfgelegdeKaartenBereikt(Throwable cause){
        super(cause);
    }
}
