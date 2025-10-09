public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if (texto==null || texto == "") throw new Exception("Texto igual a null ou vazio");

        this.texto=texto;
    }

    public int getQuantidade (char letra)
    {
        int contador = 0;
        for(int i = 0; i < this.texto.length(); i++)
        {
            char caractereAtual = this.texto.charAt(i);
            if (Character.toUpperCase(caractereAtual) == Character.toUpperCase(letra)) contador++;
        }
        return contador;
    }

    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception
    {
        if (i < 0) throw new Exception("Índice de ocorrência negativo: " + i);
        int ocorrencias = 0;

        for (int pos = 0; pos < this.texto.length(); pos++)
        {
            char caractereAtual = this.texto.charAt(pos);
            if (Character.toUpperCase(caractereAtual) == Character.toUpperCase(letra))
            {
                if (ocorrencias == i) return pos;

                ocorrencias++;
            }
        }
        throw new Exception("Não há " + (i + 1) + " ocorrências da letra '" + letra + "' em \"" + this.texto + "\".");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false;
        if (obj.getClass()!=this.getClass()) return false;
        Palavra p = (Palavra) obj;
        if (p.texto.equalsIgnoreCase(this.texto)) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = 1;
        result = 31 * result + new String(this.texto).hashCode();
        if (result < 0) result = -result;
        return result;
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
