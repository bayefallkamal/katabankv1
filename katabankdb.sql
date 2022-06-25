-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 25 juin 2022 à 23:50
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `katabankdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `client_id` bigint(20) NOT NULL,
  `nomclient` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`client_id`, `nomclient`) VALUES
(1, 'Moustapha'),
(2, 'Serigne');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `compte_id` bigint(20) NOT NULL,
  `accountnumber` varchar(255) NOT NULL,
  `balance` double NOT NULL,
  `code_client` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`compte_id`, `accountnumber`, `balance`, `code_client`) VALUES
(1, '66551234567', 280573, 1),
(2, '66551234568', 282667, 2),
(3, '56779888883', 67800, 1),
(5, '56779888333', 74000, 1);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `type_operation` varchar(1) NOT NULL,
  `operation_id` bigint(20) NOT NULL,
  `dateopearation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `compte_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`type_operation`, `operation_id`, `dateopearation`, `montant`, `numero`, `compte_id`) VALUES
('V', 1, '2022-06-25 16:33:58', 220, '66551234567', 1),
('V', 3, '2022-06-25 17:24:41', 220000, '66551234568', 2),
('R', 4, '2022-06-25 17:25:50', 3333, '66551234568', 2),
('V', 5, '2022-06-25 19:01:52', 6200, '56779888333', 5),
('R', 6, '2022-06-25 19:11:24', 6200, '56779888333', 5),
('V', 7, '2022-06-25 19:11:24', 6200, '56779888333', 5);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`compte_id`),
  ADD UNIQUE KEY `UK_mn731v4dpikys3df7pq2q772j` (`accountnumber`),
  ADD KEY `FK4j39u1ymy78ien5aes05ut81e` (`code_client`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`operation_id`),
  ADD KEY `FKa0ct8me4s6e469ipqb4tkdomh` (`compte_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `client_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `compte_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `operation_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK4j39u1ymy78ien5aes05ut81e` FOREIGN KEY (`code_client`) REFERENCES `client` (`client_id`);

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `FKa0ct8me4s6e469ipqb4tkdomh` FOREIGN KEY (`compte_id`) REFERENCES `compte` (`compte_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
