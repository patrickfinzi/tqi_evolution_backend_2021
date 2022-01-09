Processo seletivo TQI - desenvolvendo uma API rest para solicitação de emprestimos.

Neste projeto, foi desenvolvido um sistema para solicitação de emprestimo atraves de um API rest utilizando Spring Boot.

A tecnologia Spring foi escolhida por sua facilidade e boas praticas para a criação e execução do projeto, forncecendo ferramentas que facilitaram, melhoraram, e deixando mais intuitivo todo o processo de desenvoldimento da API, tambem foi utilizado o Gradle para gerenciamento das dependencias e utilizado o site spring initializer para criação do projeto.

Nesta API, o cliente (usuario) tem as seguintes opções :
- criação de cadastro no sistema.
- login e logout.
- solicitação de emprestimo.
- consulta de seus emprestimos.
- pagamento de parcela do emprestimo.

Durante o desenvolvimento do projeto, foi aplicado tambem no codigo o conceito de *clean code*, para deixar o codigo mais limpo, legivel e funcional, aplicando nomes de funções e variaveis condizentes as suas reais funcionalidades, deixando as funções com poucas linhas e e com funcionamento direto, isto é, fazendo somente aquilo que elas devem fazer.

Para armazenar todos os dados necessarios, seja os dados do usuario ou os dados do emprestimo criado, foi utilizado o banco de dados Postgres juntamente com a ferramenta JPA do spring para criação e mapeamento das tabelas do banco.

Para este sistema, foram identificadas e criadas duas tabelas, a de Clientes, armazenando os dados do mesmo, e a tabela de Emprestimos, guardando em si os dados referentes ao emprestimo, em uma relação 1:N, onde um cliente pode possuir varios emprestimos, mas um emprestimo esta vinculado a apenas um cliente.

Para o fluxo do projeto, cada mapeamento seria referente a uma tela no front-end que seria desenvolvida utilizando Angular, então o cliente realizaria o cadastro atraves de sua tela especifica caso ainda nao tenha feito, o login para acessar o sistema, e entao teria a opção de solicitar um emprestimo, uma vez solicitado e aprovado em outra pagina teria a opção de escolher entre visualizar e pagar a parcela de seu emprestimo.

Para o teste e execução de cada funcionalidade da API foi utilizada a ferramenta *Postman*, onde se foi possivel testar cada funcionalidade enviando dados em formato json para a api.

Para auxiliar tambem no desenvolvimento do projeto foi utilizado o plugin *Lombok*, para auxiliar e deixar mais intuitivo e menos verboso o codigo durante a criação das entidades.

Tambem foram efetuados testes unitarios utilizando o mockito para garantir o funcionamento, consistencia e qualidade do código.