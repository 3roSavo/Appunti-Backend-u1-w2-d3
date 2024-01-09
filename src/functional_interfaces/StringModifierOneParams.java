package functional_interfaces;
@FunctionalInterface
public  abstract interface StringModifierOneParams {
    public abstract String modify(String str);

    // public e abstract sono impliciti, quindi puoi anche ometterli nei metodi delle interfacce
    // la stessa interfaccia può omettere il public e l' abstract perché implicito

    // con la tecnica delle interfacce funzionali posso crearmi in questo caso quante funzioni
    // voglio per modificare stringhe dato un parametro senza dover crearmi una classe per ogni tipo
    // di operazione diversa io abbia bisogno.
}
