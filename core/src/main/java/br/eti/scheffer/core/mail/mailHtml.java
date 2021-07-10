package br.eti.scheffer.core.mail;


public class mailHtml {
	
	public static String mailText(String empresa, String hash) {
			return  "<!DOCTYPE html>" +
					   "<html lang=\"pt-BR\">" +
					   "  <head>" +
					   "    <meta charset='utf-8'>" +
					   "    <title>Confirmação de Cadastro</title>" +
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
	    				"		<p>Estamos enviando este email pois alguém solicitou cadastro em nosso sistema!</p>"+
	    				"		<p>Se foi você, segue link para confirmação de seu cadastro</p>"+
	    				"		<a href="+"http://192.168.1.111:8080/gateway/carsystem/confirm/hash/"+hash+">Clique aqui para confirmação de Cadastro</a>"+
	    				"		<p>Se não foi, favor desconsiderar este email</p>"+
	    				"	</div>"+
	    				" </body>"+
	    				"</html>";
		
	}

}
