BEGIN TRANSACTION;
CREATE TABLE Utilisateur(
	id_user INT AUTO_INCREMENT PRIMARY KEY,
	nom_user varchar(50),
	prenom_user varchar(50),
	login varchar(50) unique,
	mot_de_passe varchar(50)
	);
 
CREATE TABLE Utilisateur_Publique(
	id_user INT,
	FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	);
CREATE TABLE Utilisateur_Organisation(
	nom_organisation varchar(50),
	id_user INT, 
	FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	);

CREATE TABLE Utilisateur_Admin(
	nom_organisation varchar(50),
	id_user INT,
	FOREIGN KEY (id_user)  REFERENCES Utilisateur(id_user)
	);

CREATE TABLE Message(
  	id_msg INT PRIMARY KEY,
  	lib_msg VARCHAR(50),
  	corps_msg VARCHAR(500),
  	date_envoi VARCHAR(50),
	id_user INT,
	FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	);

CREATE TABLE Tchat(
	id_tchat INT AUTO_INCREMENT PRIMARY KEY,
	id_user1 INT,
	id_user2 INT,
	FOREIGN KEY (id_user1) REFERENCES Utilisateur(id_user),
	FOREIGN KEY (id_user2) REFERENCES Utilisateur(id_user)
	);

CREATE TABLE EchangeTchat(
	id_tchat INT,
	id_msg INT,
	FOREIGN KEY (id_tchat) REFERENCES Tchat(id_tchat),
	FOREIGN KEY (id_msg) REFERENCES Message(id_msg)
	);

CREATE TABLE ConversationGroupe(
	id_conv_grp INT AUTO_INCREMENT, 
	titre_conv varchar(50),
	id_organisation INT,
	FOREIGN KEY (id_organisation) REFERENCES Organisation(id_organisation),
	);

CREATE TABLE EchangeConversation_Groupe(
	id_conv_grp INT,
	id_msg INT,
	FOREIGN KEY (id_conv_grp) REFERENCES ConversationGroupe(id_conv_grp),
	FOREIGN KEY (id_msg) REFERENCES Message(id_msg)
	);

CREATE TABLE Organisation(
	id_organisation INT PRIMARY KEY,
	nom_groupe varchar(50)
	);

CREATE TABLE MembreOrganisation(
	id_organisation INT;
	id_user INT;
	FOREIGN KEY (id_conv_grp) REFERENCES ConversationGroupe(id_conv_grp),
	FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	);

CREATE TABLE Topic(
	id_topic INT AUTO_INCREMENT PRIMARY KEY,
	sujet_topic varchar(50),
	id_user INT,
	FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	);

CREATE TABLE EchangeTopic(
	id_topic INT,
	id_msg INT,
	FOREIGN KEY (id_topic) REFERENCES Topic(id_topic),
	FOREIGN KEY (id_msg) REFERENCES Message(id_msg)
	);

CREATE TABLE Evenement(
	id_event INT AUTO_INCREMENT PRIMARY KEY,
	nom_event varchar(50),
	description_event varchar(500)
	);

CREATE TABLE ParticipationEvent(
	id_event INT,
	id_user INT,
	participe BIT,
	FOREIGN KEY (id_event) REFERENCES Evenement(id_event),
	FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	);

	































