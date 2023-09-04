# Lab-4
Laboratório de Sistemas Operacionais 4 
Servidor Matemático
Este é um exemplo de servidor matemático que pode executar operações matemáticas simples, como soma, subtração, multiplicação e divisão, e responder às solicitações dos clientes. O servidor e o cliente se comunicam usando sockets TCP.

Protocolo de Comunicação
O protocolo de comunicação entre o cliente e o servidor segue o seguinte formato:   operacao:primeiro_valor:segundo_valor

operacao: A operação matemática a ser executada.
As operações suportadas incluem "soma", "subtrai", "multiplica" e "divide".
primeiro_valor e segundo_valor: Os valores numéricos sobre os quais a operação será realizada.

COMO EXECUTAR O PROGRAMA
Executando o Servidor
Abra um terminal e navegue até o diretório onde o arquivo ServidorMatematico.java está localizado.

Compile o servidor usando o seguinte comando:
javac ServidorMatematico.java

Inicie o servidor com o seguinte comando:
java ServidorMatematico

Executando o Cliente
Abra um novo terminal.

Navegue até o diretório onde o arquivo ClienteMatematico.java está localizado. 

Compile o cliente usando o seguinte comando:
javac ClienteMatematico.java

Execute o cliente com o seguinte comando, fornecendo a operação e os valores desejados:
java ClienteMatematico operacao primeiro_valor segundo_valor

Substitua operacao pela operação desejada ("soma", "subtrai", "multiplica" ou "divide") e primeiro_valor e segundo_valor pelos valores numéricos apropriados.
Por exemplo, para somar 3 e 4, você pode executar:
java ClienteMatematico soma 3 4
A resposta do servidor será exibida no terminal.

OBSERVAÇÕES
O código do servidor e do cliente inclui tratamento de erros básico para lidar com situações como divisão por zero, operações inválidas e formato de mensagem inválido.

