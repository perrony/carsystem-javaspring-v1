package br.eti.scheffer.core.mail;

public class ConfirmHtml {
	 
	public static String confirmHtml(String mensagem) {
		return  "<!DOCTYPE html>" +
				   "<html lang=\"pt-BR\">" +
				   "  <head>" +
				   "    <meta charset='utf-8'>" +
				   "    <title>Confirmação de Cadastro</title>" +
				   "	<style>" +
				   "		body {"+
				   "			background-color: #FFFFFF;"+
				   "		}"+
				   "		.confirma {"+
				   "			background-color: #D4AC0D;"+
				   "			padding: 15px;"+
				   "			margin: 20px auto;"+
				   "			text-align: center;"+
				   "			width: 80%;"+
				   "			border-radius: 10px;"+
				   "		}"+
				   "		.text-body {"+
				   "			background-color: #D6DBDF;"+
				   "			padding: 15px;"+
				   "			margin: 20px auto;"+
				   "			width: 80%;"+
				   "			border-radius: 10px;"+
				   "			text-align: center;"+
				   "    }"+
				   "	</style>"+	
				   "  </head>"+
				   "<body>"+
				   "	<div class='confirma'>"+
				   "		<h1>Confirmação de Cadastro</h1>"+
				   "	</div>"+
				   "	<div class='text-body'>"+
				   "		<h2>"+ mensagem + "</h2>"+
				   "		<p>Em caso de dúvidas, entrar em contato com o administrador do sistema!</p>"+
				   "	</div>"+
				   " </body>"+
				   "</html>";
	
		}
	

}
