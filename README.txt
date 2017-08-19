################################################################################
# Ferramentas/Aplicações utilizadas no desenvolvimento
################################################################################

* Linux CentOS 7
* Apache Maven 3.3.9
* Eclipse Neon
	* Pulign m2e 1.7
* MySQL 5.7.19


################################################################################
# Criação do banco de dados
################################################################################

* Logar no MySQL
* Criar o esquema db_xy_inc com o usuário de sua preferência
* Execute o seguinte script sql para criação das tabelas
	* [PATH_PROJECT]/xy-inc-all/config/tables.sql
* Depois será necessário informar as credencias de acesso ao banco de dados no
  arquivo de configuração da aplicação "middleware.properties"


################################################################################
# Instruções para importação do projeto
################################################################################

* Realizar download o projeto do repositório
* Importar projeto no Eclipse
	* File => Import => Existing Maven Projects
	* Selecione o diretório no qual foi feito download
	* Finalizar importação


################################################################################
# Instruções para build da aplicação
################################################################################

* Acessar o arquivo middleware.properties
* Altere as propriedades abaixo
	* jdbc.username
	* jdbc.password
* Usuári e senha devem ser os mesmos que criaram a base de dados e as tabelas

* O build pode ser feito via command line ou no próprio eclipse
* No Eclipse:
	* Clique com o botão direito do mouse sobre o projeto xy-inc-all
	* Run As => Run Configurations
	* Clique com o botão direito do mouse sobre a opção Maven Build, depois selecione a opção New
	* Informe os campos:
		* Nome: xy-inc-build
		* Diretório: ${workspace_loc:/xy-inc-all}
		* Goals: clean install
* Command line:
	* Acesso o diretório do projeto
	* Execute o comando: mvn clean install


################################################################################
# Instruções para execução e testes da aplicação
################################################################################

* O execução pode ser feito via command line ou no próprio eclipse
* No Eclipse:
	* Clique com o botão direito do mouse sobre o projeto xy-inc-all
	* Run As => Run Configurations
	* Clique com o botão direito do mouse sobre a opção Maven Build, depois selecione a opção New
	* Informe os campos:
		* Nome: xy-inc-run
		* Diretório: ${workspace_loc:/xy-inc-all}
		* Goals: tomcat7:run
* Command line:
	* Acesso o diretório do projeto
	* Execute o comando: mvn tomcat7:run


* A aplicação foi configurada para responder no seguinte URL: http://localhost:9090
* O módulo xy-inc-middleware possui cobertura de testes nas classes DAO e Service
	* Ao executar o build da aplicação e opção "Skip Tests" não for informada, o testes serão executados

* Lista dos endpoints disponibilizados:
	* Cadastro de Domínios (Entidades e Campos customizados)
		* http://localhost:9090/rest/domain/findAll
		* http://localhost:9090/rest/domain/findByPK/{ID}
		* http://localhost:9090/rest/domain/save
		* http://localhost:9090/rest/domain/update
		* http://localhost:9090/rest/domain/delete
	* Registro de Domínios(Informando para cada domínio os valores para seus respectivos campos)
		* http://localhost:9090/rest/registerDomain/findAll
		* http://localhost:9090/rest/registerDomain/findByPK/{ID}
		* http://localhost:9090/rest/registerDomain/save
		* http://localhost:9090/rest/registerDomain/update
		* http://localhost:9090/rest/registerDomain/delete


