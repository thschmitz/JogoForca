import java.util.*;
/*
    Ao iniciar o programa, deve ser carregado um vetor com 50 palavras de no mínimo 6 letras (em maiúsculo, sem acentos e sem caracteres especiais: ´ ~ ç ^). O programa sorteia aleatoriamente uma palavra para desafiar o usuário. Cada letra da palavra a ser descoberta deve ser exibida com o caractere _ e um espaço.

    Assim, a palavra CANECA deve ser exibida como _ _ _ _ _ _.

    Ao acertar uma letra, todas as correspondentes na palavra secreta devem ser alteradas, por exemplo, se o usuário digitar C a palavra exibida deve ser alterada para C _ _ _ C _.

    Se o usuário digitar uma letra que não existe na palavra, a letra deve ser armazenada em um vetor e o programa deve marcar uma das seis partes do corpo na forca. Letras que já foram digitadas anteriormente, seja na palavra secreta, seja na lista de letras erradas, não devem descontar vida do jogador.  Ao desenhar a última parte do corpo o jogador perde.  A palavra secreta deve ser revelada, junto com uma mensagem informando que o jogador perdeu. Se o jogador ganhar, deve ser impressa uma mensagem dando parabéns ao jogador.

 */
class jogoForca {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    Boolean continuar = true, segundaTentativa = false;

    while(continuar){
        
        // DECLARACOES DE VARIAVEIS JOGO 1 e 2

        // JOGO01
        Boolean venceu = false;
        int vidas = 6, contador = 0, modo=0;
        String letra = "", letrasErradas[];
        letrasErradas = new String[6];
        String boneco[][], boneco02[][];
        boneco = new String[7][15];
        boneco02 = new String[7][30];
        char resposta = ' ';

        // JOGO 02
        boolean venceu01 = false, venceu02 = false, venceuReal = false;
        int vidas01 = 6, vidas02 = 6, contador01 = 0, contador02 = 0;

        //ESCOLHA DE MODO DE JOGO (1 e 2)
        System.out.println("Os modos de jogo são: \n1 - Modo padrão\n2 - Modo dueto");
        System.out.print("Qual modo de jogo? (1) - (2) : ");
        modo = entrada.nextInt();

        System.out.println(modo);

        if(modo == 1){
            System.out.println("Modo padrão escolhido");
        
            // SORTEIA A PALAVRA JOGO 1
            Random numRand = new Random();
            int valorSorteado = numRand.nextInt(50);

            // Carregar matriz forca JOGO 1
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 15; j++) {
                    boneco[i][j] = " ";
                    boneco[i][0] = "|";
                    boneco[6][j] = "_";
                }
            }

            for(int i = 0; i < 7; i++){
                for (int j = 0; j < 8; j++) {
                    boneco[0][j] = "_";
                    boneco[1][6] = "|";
                }
            }
            
            // Printagem da matriz forca JOGO 1
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 15; j++) {
                    System.out.print(boneco[i][j]);
                }
                System.out.println();
            }
            System.out.print("\n");

            // LISTA COM 50 PALAVRAS ALEATORIAS JOGO 1
            String[] nomes = {"CANECA", "CADEIRA", "CADEADO", "CADERNO", "ALISTAMENTO", "GIRAFA", "CARROS", "DOCUMENTARIO", "BRASIL", "COMPUTADOR", "PROGRAMADOR", "MONITOR", "CAMERA", "ESTOJO", "LISTRADO", "LUSTRE", "BANANA", "HIPOPOTAMO", "ELEFANTE", "PINGUIM", "ASTRONAUTA", "PATINS", "BUNDAS", "PORCOS", "GUILHOTINA", "VENTILADOR", "PISCINA", "ESCADA", "ESTADIO", "CIRCULAR", "ESMOLA", "COMUNISTA", "VAGABUNDO", "BRASILEIRO", "PIPOCA", "BOLOTA", "HOMOSSEXUAL", "ATLETA", "GARRAFA", "INSETO", "AMARELO", "VERMELHO", "MARROM", "ESCRITOR", "IMPRESSORA", "IGUANA", "TECLADO", "NAVEGADOR", "ESPORTISTA", "MOLUSCO" };
            String palavraSorteada = nomes[valorSorteado];
            
            // VETOR COM A PALAVRA SORTEADA JOGO 1
            char[] palavraSorteadaArray = new char[palavraSorteada.length()];
            String palavraSorteadaFormatada[] = new String[palavraSorteada.length()];

            // QUANTIDADE DE LETRAS PRO USUARIO JOGO 1
            System.out.print("Palavra secreta: ");
            for (int i=0; i<palavraSorteada.length(); i++){   
                palavraSorteadaArray[i] = palavraSorteada.charAt(i);
                palavraSorteadaFormatada[i] = "_ ";
                System.out.print(palavraSorteadaFormatada[i]);
            }
            
            // INPUTS PARA O USUARIO DIGITAR COM REPETICOES ATE ACERTAR JOGO 1
            do{
                System.out.print("\n\nDigite uma letra (Sem acentos): ");
                letra = entrada.next();
                letra = letra.toUpperCase();

                // VERIFICA SE A LETRA JA FOI DIGITADA ANTES JOGO 1
                if(palavraSorteada.contains(letra)){
                    for (int i=0; i<palavraSorteada.length(); i++){
                        if(palavraSorteada.charAt(i) == letra.charAt(0)){
                            palavraSorteadaFormatada[i] = letra;
                        }
                    }
                    
                    // Verifica se o usuario ganhou JOGO 1
                    for(int i=0; i<palavraSorteada.length(); i++){
                        if(palavraSorteadaFormatada[i].equals("_ ")){
                            venceu = false;
                            break;
                        }else{
                            venceu = true;
                        }
                    }

                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 15; j++) {
                            System.out.print(boneco[i][j]);
                            }
                        System.out.println();
                    }
                }else{
                    //AUMENTA O BONECO JOGO 1
                    switch(vidas){
                        case 6: 
                            boneco[2][6] = "O";
                            break;
                        case 5: 
                            boneco[3][6] = "|";
                            break;
                            
                        case 4: 
                            boneco[3][5] = "/";
                            break;
                        case 3: 
                            boneco[3][7] = "\\";
                            break;
                        case 2: 
                            boneco[4][5] = "/";
                            break;
                        case 1:
                            boneco[4][7] = "\\";
                            break;
                        case 0:
                            break;
                        
                    }
                        
                    //ADICIONA LETRA ERRADA AO VETOR JOGO 1
                    System.out.println("\nLetra não encontrada!");
                    letrasErradas[contador] = letra;
                    contador++;
                    vidas--;

                    // PRINTAGEM DO BONECO JOGO 1
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < 15; j++) {
                            System.out.print(boneco[i][j]);
                        }
                        System.out.println();
                    }
                }
                System.out.print("\n");

                // IMPRIME A PALAVRA SORTEADA COM OS CARACTERES CORRETOS JOGO 1
                System.out.print("\nPalavra: ");
                for (int i=0; i<palavraSorteada.length(); i++){
                    System.out.print(palavraSorteadaFormatada[i] + " ");
                }

                System.out.print("\n\n");

                //IMPRIME AS LETRAS ERRADAS JOGO 1
                if(letrasErradas.length > 0){
                    System.out.println("As letras erradas até o momento são: " );
                    for (int i=0; i< 6; i++){
                        if(letrasErradas[i] != null){
                            System.out.print(letrasErradas[i] + " ");
                        }
                    }
                }

            }while (vidas > 0 && venceu == false);

            if(vidas == 0){ 
                System.out.println("\nVocê perdeu!");
                System.out.println("\nPalavra secreta: " + palavraSorteada);
            } else if(venceu) {
                System.out.println("\nVocê venceu!");
            }
            
            // PERGUNTA AO USUARIO SE QUER CONTINUAR JOGO 1
            System.out.print("Você deseja continuar? (S/N): ");
            resposta = entrada.next().charAt(0);

            if(resposta == 'S'){
                // RESETANDO VARIAVEIS E MATRIZES JOGO 1
                palavraSorteada = "";
                continuar = true;
                segundaTentativa = true;
            }else if(resposta=='N'){
                continuar = false;
            } else {
                System.out.println("\nResposta invalida!");
                continuar = false;
            }

            // TERMINO JOGO 1
        }
        // COMECO JOGO 2
        if(modo == 2){
            modo = 2;
            System.out.println("Modo dueto escolhido!");
            System.out.println("\nBem-vindo ao jogo dueto!");
            System.out.println("\nO jogo consiste em uma partida com 2 jogos simultâneos.");
            System.out.println("\nAmbas as palavras secretar possuirão 5 letras.");
            System.out.println("\nCada letra inserida contará para ambas as forcas, esteja ela errada ou correta.");
            System.out.println("\nA cada erro, você perderá uma vida na forca em que o erro foi cometido.");
            System.out.println("\nCaso perca todas as vidas em qualquer uma das duas forcas, você perde.");
            System.out.println("\nCaso consiga preencher todas as letras de ambas as palavras secretas, você vence.");
            System.out.println("\nBoa sorte!");
            System.out.println("\n");

            String[] lista01 = {"sagaz","magos","negro","exito","mexer","termo","senso","nobre","algoz","afeto","plena","etica","mutua","tenue","sutil","vigor","aquem","fazer","porem","audaz","sanar","termo","assim","inato","cerne","fosse","apice","ansia","orgia","animo","ceder","brado","comum","gleba","sendo","temor","assaz","culto","arroz","mundo","pauta","censo","fugaz","ainda","cozer","valor","denso","nenem","vicio","forte",};
            String[] lista02 = {"genio","legal","olhar","burro","possa","ameno","levar","reles","tecer","casta","obito","tesao","prime","selar","morte","ratos","anelo","fator","notar","rogar","noite","fazer","citar","sabia","farsa","cabal","achar","adiar","coeso","falta","nicho","cuzao","epico","ouvir","fardo","viver","ativo","brega","forca","sinto","gente","imune","exato","haste","passo","amplo","sonso","dubio","cesta","lavra",};

            // SELECIONA UMA PALAVRA ALEATÓRIA DO VETOR DE PALAVRAS
            Random numRandLista01 = new Random();
            Random numRandLista02 = new Random();

            int valorSorteadoLista01 = numRandLista01.nextInt(50);
            int valorSorteadoLista02 = numRandLista02.nextInt(50);

            // MONTAGEM DA MATRIZ JOGO FORCA 2
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 30; j++) {
                    boneco02[i][j] = " ";
                    boneco02[6][j] = "_";
                    boneco02[i][0] = "|";
                    boneco02[i][29] = "|";
                }
            }

            for(int i = 0; i < 7; i++){
                for (int j = 0; j < 30; j++) {
                    boneco02[0][j] = "_";
                    boneco02[1][6] = "|";
                    boneco02[1][23] = "|";
                }
            }
            
            // Printagem da matriz forca JOGO 2
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 30; j++) {
                    System.out.print(boneco02[i][j]);
                }
                System.out.println();
            }
            System.out.print("\n");


            String palavraSorteadaLista01 = lista01[valorSorteadoLista01].toUpperCase();
            String palavraSorteadaLista02 = lista02[valorSorteadoLista02].toUpperCase();


            // VETOR COM A PALAVRA SORTEADA DA LISTA 01 JOGO 2
            char[] palavraSorteadaArrayLista01 = new char[5];
            String palavraSorteadaFormatadaLista01[] = new String[5];

            // VETOR COM A PALAVRA SORTEADA DA LISTA 02 JOGO 2
            char[] palavraSorteadaArrayLista02 = new char[5];
            String palavraSorteadaFormatadaLista02[] = new String[5];

            // QUANTIDADE DE LETRAS PRO USUARIO JOGO 2
            System.out.print("Primeira palavra secreta: ");
            for (int i=0; i<palavraSorteadaLista01.length(); i++){   
                palavraSorteadaArrayLista01[i] = palavraSorteadaLista01.charAt(i);
                palavraSorteadaFormatadaLista01[i] = "_ ";
                System.out.print(palavraSorteadaFormatadaLista01[i]);
            }
            System.out.println("\n");

            System.out.print("Segunda palavra secreta: ");
            for (int i=0; i<palavraSorteadaLista02.length(); i++){   
                palavraSorteadaArrayLista02[i] = palavraSorteadaLista01.charAt(i);
                palavraSorteadaFormatadaLista02[i] = "_ ";
                System.out.print(palavraSorteadaFormatadaLista02[i]);
            }

            System.out.println("\n");

            // COMECO DOS CHUTES JOGO 2
            do{
                System.out.print("\n\nDigite uma letra (Sem acentos): ");
                letra = entrada.next();
                letra = letra.toUpperCase();

                System.out.println("\n");
                System.out.println("Palavra: " + palavraSorteadaLista01);
                System.out.println("Letra1: " + palavraSorteadaLista01.contains("A"));
                System.out.println("Palavra2: " + palavraSorteadaLista02);
                System.out.println("\n");
                // VERIFICA SE A LETRA JA FOI DIGITADA ANTES JOGO 2
                if(palavraSorteadaLista01.contains(letra)){
                    for (int i=0; i<5; i++){
                        if(palavraSorteadaLista01.charAt(i) == letra.charAt(0)){
                            palavraSorteadaFormatadaLista01[i] = letra;
                        }
                    }
                    
                    // Verifica se o usuario ganhou JOGO 1
                    for(int i=0; i<palavraSorteadaLista01.length(); i++){
                        if(palavraSorteadaFormatadaLista01[i].equals("_ ")){
                            venceu01 = false;
                            break;
                        }else{
                            venceu01 = true;
                        }
                    }

                }else{
                    //AUMENTA O BONECO JOGO 1
                    switch(vidas01){
                        case 6: 
                            boneco02[2][6] = "O";
                            break;
                        case 5: 
                            boneco02[3][6] = "|";
                            break;
                            
                        case 4: 
                            boneco02[3][5] = "/";
                            break;
                        case 3: 
                            boneco02[3][7] = "\\";
                            break;
                        case 2: 
                            boneco02[4][5] = "/";
                            break;
                        case 1:
                            boneco02[4][7] = "\\";
                            break;
                        case 0:
                            break;
                        
                    }

                        
                    //ADICIONA LETRA ERRADA AO VETOR JOGO 2
                    
                    if(!palavraSorteadaLista02.equals(letra)){
                        letrasErradas[contador] = letra;
                    }
                    contador++;
                    vidas01--;
                }

                if(palavraSorteadaLista02.contains(letra)) {
                    for(int i=0; i<5; i++){
                        if(palavraSorteadaLista02.charAt(i) == letra.charAt(0)){
                            palavraSorteadaFormatadaLista02[i] = letra;
                        }
                    }
                    
                    // Verifica se o usuario ganhou JOGO 1
                    for(int i=0; i<5; i++){
                        if(palavraSorteadaFormatadaLista02[i].equals("_ ")){
                            venceu02 = false;
                            break;
                        }else{
                            venceu02 = true;
                        }
                    }


                }else{
                    switch(vidas02){
                        case 6: 
                            boneco02[2][23] = "O";
                            break;
                        case 5: 
                            boneco02[3][23] = "|";
                            break;
                            
                        case 4: 
                            boneco02[3][22] = "/";
                            break;
                        case 3: 
                            boneco02[3][24] = "\\";
                            break;
                        case 2: 
                            boneco02[4][22] = "/";
                            break;
                        case 1:
                            boneco02[4][24] = "\\";
                            break;
                        case 0:
                            break;
                        
                    }

                    contador++;
                    vidas02--;

                }

                //PRINT DO BONECO JOGO 2
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 30; j++) {
                        System.out.print(boneco02[i][j]);
                    }
                    System.out.println();
                }
                System.out.print("\n");
                    
                // IMPRIME A PALAVRA SORTEADA COM OS CARACTERES CORRETOS JOGO 2
                System.out.print("\nPrimeira palavra: ");
                for (int i=0; i<5; i++){
                    System.out.print(palavraSorteadaFormatadaLista01[i] + " ");
                }

                System.out.print("\nSegunda palavra: ");
                for(int i = 0; i<5; i++){
                    System.out.print(palavraSorteadaFormatadaLista02[i] + " ");
                }

                System.out.print("\n\n");

                //IMPRIME AS LETRAS ERRADAS JOGO 2
                if(letrasErradas.length > 0){
                    System.out.println("As letras erradas até o momento são: " );
                    for (int i=0; i< 6; i++){
                        if(letrasErradas[i] != null){
                            System.out.print(letrasErradas[i] + " ");
                        }
                    }
                }
            } while(vidas01 > 0 && vidas02 > 0);

            if(vidas01 == 0 || vidas02 == 0 ){
                System.out.println("\n\nVocê perdeu!");
                System.out.println("\nPalavra Secreta 1: " + palavraSorteadaLista01);
                System.out.println("\nPalavra Secreta 2: " + palavraSorteadaLista02);
            }
            System.out.print("Você deseja continuar? (S/N): ");
            resposta = entrada.next().charAt(0);

            if(resposta == 'S'){
                // RESETANDO VARIAVEIS E MATRIZES JOGO 2
                palavraSorteadaLista01 = "";
                palavraSorteadaLista02 = "";
                continuar = true;
                segundaTentativa = true;
            }else if(resposta=='N'){
                continuar = false;
            } else {
                System.out.println("\nResposta invalida!");
                continuar = false;
            }

            // TERMINO JOGO 2
        }
    }
    entrada.close();
  }
}
