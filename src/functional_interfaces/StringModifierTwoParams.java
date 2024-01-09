package functional_interfaces;
@FunctionalInterface
public abstract interface StringModifierTwoParams {
    public abstract String modify(String str1, String str2);

    // public e abstract sono impliciti, quindi puoi anche ometterli nei metodi delle interfacce
    // la stessa interfaccia può omettere il public e l' abstract perché implicito

    // con la tecnica delle interfacce funzionali posso crearmi in questo caso quante funzioni
    // voglio per modificare stringhe dati due parametri senza dover crearmi una classe per ogni tipo
    // di operazione diversa io abbia bisogno.

    // Posso addirittura crearmi metodi concreti
    default void ciaone() {
        System.out.println("metodo di default");
    }
}
