package br.eti.scheffer.core.mail;


public class resetHtml {
	
	public static String mailText(String empresa, String hash) {
			return  "<!DOCTYPE html>" +
					   "<html lang=\"pt-BR\">" +
					   "  <head>" +
					   "    <meta charset='utf-8'>" +
					   "    <title>Reset de Senha</title>" +
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
	    				"		<h1>Reset de Senha</h1>"+
	    				"	</div>"+
	    				"	<div class='text-body'>"+
	    				"		<h2>"+ empresa.trim() + "</h2>"+
	    				"		<p>Estamos enviando este email pois alguém solicitou recadastrar a senha em nosso sistema!</p>"+
	    				"		<p>Se foi você, segue link para formulario de redefiniçao de senha</p>"+
	    				"		<a href="+"http://localhost:4200/resetform?hash="+hash+">Clique aqui para redefinir senha</a>"+
	    				"		<p>Se não foi, favor desconsiderar este email</p>"+
	    				"	</div>"+
	    				" </body>"+
	    				"</html>";
		
	}

}
