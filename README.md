# Marvel Store

Esse é um projeto que simula uma loja virtual para visualização e compra de quadrinhos da Marvel Comics.
A linguagem utilizada foi o Kotlin, para maior celeridade no desenvolvimento e por maior familiaridade pessoal.

A versão do Android Studio utilizada foi a 3.4.2 e a versão do Gradle foi a 5.1.1.

O aplicativo tem o funcionamento da seguinte forma:
- O usuário abre o aplicativo e recebe uma lista de quadrinhos, cada item é clicável e leva à tela de Detalhes do Quadrinho.
- Na tela de detalhes, o usuário confere o item escolhido, e pode escolher a quantidade de quadrinhos daquele modelo que serão comprados.
- Essa interação leva à terceira tela, que é a tela de checkout, onde o usuário checa se o produto foi correto e pode aplicar um cupom de desconto.

    cupons de desconto -> Cupom raro = "rareCoupon"

    cupons de desconto -> Cupom comum = "commonCoupon"
    
Quando o botão de finalizar compra for clicado, o aplicativo volta ao estágio inicial
