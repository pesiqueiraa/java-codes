import java.util.ArrayList;

public class Treinador extends Pessoa {
    /*
        Defina 3 atributos privados:
        - listaPokemons, do tipo ArrayList, que guarda objetos da classe Pokemon;
        - vitorias, derrotas, do tipo int.

        Além disso, Treinador herde da classe Pessoa. Ou seja, a classe Treinador
        guanhará os métodos getNome(), setNome(), getIdade() e setIdade() por herança.
    */

    private ArrayList<Pokemon> listaPokemons;
    private int vitorias;
    private int derrotas;



    public Treinador(String nome, int idade) {
        /*
        Construtor da classe
        Recebe os 2 parâmetros indicados acima. Como esses valores são manipulados pela
        classe Pessoa, da qual Treinador deve herdar, utilize a função super() para passar
        esses valores para que o construtor de Pessoa os inicialize.

        Além disso, faça com que:
        - o atributo privado listaPokemons seja um ArrayList vazio;
        - o atributo privado vitorias seja zero;
        - o atributo privado derrotas seja zero.
        */
        super(nome, idade);
        this.listaPokemons = new ArrayList<>();
        this.vitorias = 0;
        this.derrotas = 0;
    }

    public boolean adicionarPokemon(Pokemon pokemon) {
        /*
        Recebe um objeto Pokemon por parâmetro e o adiciona no fim da listaPokemons.

        OBS: o método não deve permitir que um treinador tenha mais de um Pokémon com
        o mesmo nome.

        Deve retornar true se inseriu o Pokémon com sucesso, e false caso contrário (caso
        já exista um Pokémon com o mesmo nome).
        */
        for (Pokemon p : listaPokemons) {
            if (p.getNome().equals(pokemon.getNome())) {
                return false;
            }
        }
        listaPokemons.add(pokemon);
        return true;
    }

    public ArrayList<Pokemon> getListaPokemons() {
        /*
        Retorna o objeto que representa um ArrayList de Pokémons (atributo privado listaPokemons).
        */
        return this.listaPokemons;
    }

    public int totalPokemons() {
        /*
        Retorna o número total de Pokémons na listaPokemons.
        */
        return this.listaPokemons.size();
    }

    public int ataqueTotal() {
        /*
        Retorna a soma dos ataques de todos os Pokémons na listaPokemons.
        */
        int total = 0;
        for (Pokemon p : listaPokemons) {
            total += p.getAtaque();
        }
        return total;
    }

    public int getVitorias() {
        /*
        Retorna o valor do atributo privado vitorias.
        */
        return this.vitorias;
    }

    public void incVitorias() {
        /*
        Incrementa o atributo vitorias em 1 unidade.
        */
        this.vitorias++;
    }

    public int getDerrotas() {
        /*
        Retorna o valor do atributo privado derrotas.
        */
        return this.derrotas;
    }

    public void incDerrotas() {
        /*
        Incrementa o atributo derrotas em 1 unidade.
        */
        this.derrotas++;
    }

    public static void main(String[] args) {
        /* Método main para testes
           Não é necessário implementá-lo, mas você pode testar as funcionalidades da classe Treinador aqui.
        */
    }

}
