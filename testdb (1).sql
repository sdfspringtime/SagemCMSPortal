-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 10 mai 2022 à 17:53
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `testdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(15);

-- --------------------------------------------------------

--
-- Structure de la table `lines_p`
--

DROP TABLE IF EXISTS `lines_p`;
CREATE TABLE IF NOT EXISTS `lines_p` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `lines_p`
--

INSERT INTO `lines_p` (`id`, `description`, `name`) VALUES
(2, 'la 2eme ligneaaa', 'line5'),
(3, 'test', 'line3'),
(4, 'please work', 'line4');

-- --------------------------------------------------------

--
-- Structure de la table `lines_p_aud`
--

DROP TABLE IF EXISTS `lines_p_aud`;
CREATE TABLE IF NOT EXISTS `lines_p_aud` (
  `id` bigint NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKc96ld8otmby92xjg95s1llgt6` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `lines_p_aud`
--

INSERT INTO `lines_p_aud` (`id`, `rev`, `revtype`, `description`, `name`) VALUES
(1, 2, 1, 'ligneprod1', 'aa123'),
(1, 3, 1, 'ligneprod2', 'aa123'),
(1, 4, 1, 'ligneprod2', 'aa1234'),
(1, 5, 1, 'ligneprod2', 'aa12345'),
(1, 6, 1, 'ligneprod2', 'aa12346'),
(1, 7, 1, 'ligneprod2', 'aa12347'),
(1, 8, 1, 'ligneprod2', 'aa1234447'),
(1, 11, 2, NULL, NULL),
(2, 9, 0, 'la 2eme ligne', 'line1'),
(2, 12, 1, 'la 2eme ligne', 'line4'),
(2, 13, 1, 'la 2eme ligneaaa', 'line5'),
(3, 10, 0, 'test', 'line3'),
(4, 14, 0, 'please work', 'line4');

-- --------------------------------------------------------

--
-- Structure de la table `line_alloc`
--

DROP TABLE IF EXISTS `line_alloc`;
CREATE TABLE IF NOT EXISTS `line_alloc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `allocated_at` datetime DEFAULT NULL,
  `line_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoan2uvmjwq8m4f7w3kcqict30` (`line_id`),
  KEY `FKpk79o5a000xxhjwcu5ibsshm4` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `line_alloc_aud`
--

DROP TABLE IF EXISTS `line_alloc_aud`;
CREATE TABLE IF NOT EXISTS `line_alloc_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `allocated_at` datetime DEFAULT NULL,
  `line_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKcoe7p8w72s3v39mys33xr5b7d` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `line_alloc_aud`
--

INSERT INTO `line_alloc_aud` (`id`, `rev`, `revtype`, `allocated_at`, `line_id`, `user_id`) VALUES
(1, 11, 2, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `machines`
--

DROP TABLE IF EXISTS `machines`;
CREATE TABLE IF NOT EXISTS `machines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fese` bit(1) NOT NULL,
  `allocated` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `typemach` varchar(255) DEFAULT NULL,
  `line_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnf0p9k04dina1fcbyc8v9y2cd` (`line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `machines_aud`
--

DROP TABLE IF EXISTS `machines_aud`;
CREATE TABLE IF NOT EXISTS `machines_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `fese` bit(1) DEFAULT NULL,
  `allocated` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `typemach` varchar(255) DEFAULT NULL,
  `line_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKci3xrg94ad3b1y4ibrdy8iowi` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `machine_alloc`
--

DROP TABLE IF EXISTS `machine_alloc`;
CREATE TABLE IF NOT EXISTS `machine_alloc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `allocated_at` datetime DEFAULT NULL,
  `machine_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7794tq374yqou329cuadk6ikd` (`machine_id`),
  KEY `FKhge1poohpi401r8k0uwmke154` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `machine_alloc_aud`
--

DROP TABLE IF EXISTS `machine_alloc_aud`;
CREATE TABLE IF NOT EXISTS `machine_alloc_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `allocated_at` datetime DEFAULT NULL,
  `machine_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK9njn04x35obkbuf0nkiyn6pvo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `my_revision`
--

DROP TABLE IF EXISTS `my_revision`;
CREATE TABLE IF NOT EXISTS `my_revision` (
  `id` int NOT NULL,
  `timestamp` bigint NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  `isline` bit(1) DEFAULT NULL,
  `ismachine` bit(1) DEFAULT NULL,
  `isuser` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `my_revision`
--

INSERT INTO `my_revision` (`id`, `timestamp`, `user`, `isline`, `ismachine`, `isuser`) VALUES
(1, 1644263703688, NULL, NULL, NULL, NULL),
(2, 1644263921859, NULL, NULL, NULL, NULL),
(3, 1644264413449, NULL, NULL, NULL, NULL),
(4, 1644602403016, NULL, NULL, NULL, NULL),
(5, 1644602713980, NULL, NULL, NULL, NULL),
(6, 1644602758850, NULL, NULL, NULL, NULL),
(7, 1644605239511, NULL, NULL, NULL, NULL),
(8, 1644605493320, 'idriss', NULL, NULL, NULL),
(9, 1647032352028, 'idriss', NULL, NULL, NULL),
(10, 1647033304990, 'idriss', NULL, NULL, NULL),
(11, 1647035268304, 'idriss', NULL, NULL, NULL),
(12, 1647459819457, 'idriss', NULL, NULL, NULL),
(13, 1650141143971, 'idriss', b'0', b'0', b'0'),
(14, 1650578388547, 'idriss', b'0', b'0', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_MACHINIST'),
(3, 'ROLE_LMANAGER');

-- --------------------------------------------------------

--
-- Structure de la table `roles_aud`
--

DROP TABLE IF EXISTS `roles_aud`;
CREATE TABLE IF NOT EXISTS `roles_aud` (
  `id` int NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKh8jo79oe92en6mxf8w3wtdub2` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(1, 'mohamedidriss.abbes@esprit.tn', '$2a$10$z3yhBSOD9860upsvOhSojuLZJaSXw4xdaDnOpAhDZsbQfasC76pFu', 'idriss');

-- --------------------------------------------------------

--
-- Structure de la table `users_aud`
--

DROP TABLE IF EXISTS `users_aud`;
CREATE TABLE IF NOT EXISTS `users_aud` (
  `id` bigint NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK29gpbqr3w99i881k776ovjs63` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users_aud`
--

INSERT INTO `users_aud` (`id`, `rev`, `revtype`, `email`, `password`, `username`) VALUES
(1, 1, 0, 'mohamedidriss.abbes@esprit.tn', '$2a$10$z3yhBSOD9860upsvOhSojuLZJaSXw4xdaDnOpAhDZsbQfasC76pFu', 'idriss'),
(1, 11, 1, 'mohamedidriss.abbes@esprit.tn', '$2a$10$z3yhBSOD9860upsvOhSojuLZJaSXw4xdaDnOpAhDZsbQfasC76pFu', 'idriss');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user_roles_aud`
--

DROP TABLE IF EXISTS `user_roles_aud`;
CREATE TABLE IF NOT EXISTS `user_roles_aud` (
  `rev` int NOT NULL,
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  PRIMARY KEY (`rev`,`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user_roles_aud`
--

INSERT INTO `user_roles_aud` (`rev`, `user_id`, `role_id`, `revtype`) VALUES
(1, 1, 2, 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `lines_p_aud`
--
ALTER TABLE `lines_p_aud`
  ADD CONSTRAINT `FKc96ld8otmby92xjg95s1llgt6` FOREIGN KEY (`rev`) REFERENCES `my_revision` (`id`);

--
-- Contraintes pour la table `line_alloc`
--
ALTER TABLE `line_alloc`
  ADD CONSTRAINT `FKoan2uvmjwq8m4f7w3kcqict30` FOREIGN KEY (`line_id`) REFERENCES `lines_p` (`id`),
  ADD CONSTRAINT `FKpk79o5a000xxhjwcu5ibsshm4` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `line_alloc_aud`
--
ALTER TABLE `line_alloc_aud`
  ADD CONSTRAINT `FKcoe7p8w72s3v39mys33xr5b7d` FOREIGN KEY (`rev`) REFERENCES `my_revision` (`id`);

--
-- Contraintes pour la table `machines`
--
ALTER TABLE `machines`
  ADD CONSTRAINT `FKnf0p9k04dina1fcbyc8v9y2cd` FOREIGN KEY (`line_id`) REFERENCES `lines_p` (`id`);

--
-- Contraintes pour la table `machines_aud`
--
ALTER TABLE `machines_aud`
  ADD CONSTRAINT `FKci3xrg94ad3b1y4ibrdy8iowi` FOREIGN KEY (`rev`) REFERENCES `my_revision` (`id`);

--
-- Contraintes pour la table `machine_alloc`
--
ALTER TABLE `machine_alloc`
  ADD CONSTRAINT `FK7794tq374yqou329cuadk6ikd` FOREIGN KEY (`machine_id`) REFERENCES `machines` (`id`),
  ADD CONSTRAINT `FKhge1poohpi401r8k0uwmke154` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `machine_alloc_aud`
--
ALTER TABLE `machine_alloc_aud`
  ADD CONSTRAINT `FK9njn04x35obkbuf0nkiyn6pvo` FOREIGN KEY (`rev`) REFERENCES `my_revision` (`id`);

--
-- Contraintes pour la table `roles_aud`
--
ALTER TABLE `roles_aud`
  ADD CONSTRAINT `FKh8jo79oe92en6mxf8w3wtdub2` FOREIGN KEY (`rev`) REFERENCES `my_revision` (`id`);

--
-- Contraintes pour la table `users_aud`
--
ALTER TABLE `users_aud`
  ADD CONSTRAINT `FK29gpbqr3w99i881k776ovjs63` FOREIGN KEY (`rev`) REFERENCES `my_revision` (`id`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `user_roles_aud`
--
ALTER TABLE `user_roles_aud`
  ADD CONSTRAINT `FKpg0fc0gwvvkmhdp1aeb1b2n6` FOREIGN KEY (`rev`) REFERENCES `my_revision` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
