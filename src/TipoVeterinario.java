public enum TipoVeterinario {
    DR_MARVOTA,DR_NEYMAR;
    public static TipoVeterinario validacionVeterinario(String entrada) {
        try {
            return TipoVeterinario.valueOf(entrada.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
