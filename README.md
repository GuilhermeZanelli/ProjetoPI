<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Como Rodar o Projeto</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f8f9fa;
      color: #333;
      padding: 40px;
      line-height: 1.6;
    }
    h1 {
      color: #0056b3;
    }
    ol {
      background-color: #ffffff;
      border-left: 4px solid #0056b3;
      padding: 20px;
      border-radius: 5px;
    }
    li {
      margin-bottom: 15px;
    }
    code {
      background-color: #e9ecef;
      padding: 2px 6px;
      border-radius: 4px;
      font-family: Consolas, monospace;
    }
    .info {
      margin-top: 30px;
      font-size: 0.9em;
      color: #555;
    }
  </style>
</head>
<body>

  <h1>🚀 Como Rodar o Projeto</h1>

  <ol>
    <li>Clone este repositório no seu VSCode.</li>
    <li>Instale a extensão <strong>Extension Pack for Java</strong> no VSCode.</li>
    <li>Abra o arquivo <code>script.txt</code> localizado na raiz do repositório.</li>
    <li>Copie o conteúdo do arquivo e execute no <strong>MySQL Workbench</strong> para criar o banco de dados.</li>
    <li>Na classe <code>dao/Conexao.java</code>, substitua a <code>String</code> da linha 9 pela sua senha do MySQL Workbench.</li>
    <li>Execute a classe <code>main/Main.java</code> para iniciar a aplicação.</li>
  </ol>

  <div class="info">
    💡 Este projeto foi desenvolvido em Java com conexão ao banco de dados MySQL. Certifique-se de que o servidor MySQL está ativo antes de executar a aplicação.
  </div>

</body>
</html>
