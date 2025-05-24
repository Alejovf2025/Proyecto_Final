public enum EspcieAnimal {
    PERRO,GATO,LORO,HAMSTER,CONEJO;

    public static EspcieAnimal validacion(String entrada) {
        try {
            return EspcieAnimal.valueOf(entrada.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}


