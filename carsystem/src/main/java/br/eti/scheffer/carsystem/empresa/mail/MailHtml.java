package br.eti.scheffer.carsystem.empresa.mail;


public class MailHtml {
	
	public static String mailText(String empresa) {
			return  "<!DOCTYPE html>" +
					   "<html lang=\"pt-BR\">" +
					   "  <head>" +
					   "    <meta charset='utf-8'>" +
					   "    <title>Confirmação de Cadastro de Email de Contato</title>" +
					   "	<style>" +
					   "		body {"+
					   "			ackground-color: #FFFFFF;"+
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
	    						"}"+
	    				"	</style>"+	
	    				"  </head>"+
	    				"<body>"+
	    				"	<div class='confirma'>"+
	    				"		<h1>Confirmação de Cadastro</h1>"+
	    				"	</div>"+
	    				"	<div class='text-body'>"+
	    				"		<h2>"+ empresa.trim() + "</h2>"+
	    				"		<p>Estamos enviando este email para informar que seu email está cadastrado como Contato</p>"+
	    				"	</div>"+
	    				" </body>"+
	    				"</html>";
		
	}

}
