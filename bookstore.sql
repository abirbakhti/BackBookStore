-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 03 jan. 2021 à 15:13
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `author`, `date`, `picture`, `price`, `quantity`, `title`) VALUES
(1, 'test', '2016-06-08T23:00:00.000Z', '../../assets/book1.jpg', 150, 5, 'the crying book'),
(2, 'test', '2016-06-14T23:00:00.000Z', '../../assets/book3.jpg', 250, 4, 'Wicked Endings'),
(3, 'test', '1997-12-01T23:00:00.000Z', '../../assets/book4.jpg', 520, 0, 'After Days');

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

CREATE TABLE `command` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `total_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `command`
--

INSERT INTO `command` (`id`, `date`, `total_price`) VALUES
(4, '2021-01-03 14:13:05', 2000);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_command`
--

CREATE TABLE `ligne_command` (
  `id` bigint(20) NOT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `book_id` bigint(20) NOT NULL,
  `command_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_command`
--

INSERT INTO `ligne_command` (`id`, `price`, `quantity`, `book_id`, `command_id`) VALUES
(5, 150, 10, 1, 4),
(6, 250, 2, 2, 4);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `command`
--
ALTER TABLE `command`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ligne_command`
--
ALTER TABLE `ligne_command`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm5sv9soagjmjrvv2fc0luh9oi` (`book_id`),
  ADD KEY `FK2h7qky74at07k7nitm7pn8r3p` (`command_id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ligne_command`
--
ALTER TABLE `ligne_command`
  ADD CONSTRAINT `FK2h7qky74at07k7nitm7pn8r3p` FOREIGN KEY (`command_id`) REFERENCES `command` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKm5sv9soagjmjrvv2fc0luh9oi` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
