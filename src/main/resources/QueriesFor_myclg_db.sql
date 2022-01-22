-- myclg.feereceipt definition
CREATE TABLE `feereceipt` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- myclg.feereceipt_student definition
CREATE TABLE `feereceipt_student` (
  `FeeReceipt_id` int NOT NULL,
  `studentList_id` int NOT NULL,
  KEY `FK268oo0gqv9vw0eukv2b6n1qkx` (`studentList_id`),
  KEY `FK1tmhor3bjjntp8qa3x36mafsn` (`FeeReceipt_id`),
  CONSTRAINT `FK1tmhor3bjjntp8qa3x36mafsn` FOREIGN KEY (`FeeReceipt_id`) REFERENCES `feereceipt` (`id`),
  CONSTRAINT `FK268oo0gqv9vw0eukv2b6n1qkx` FOREIGN KEY (`studentList_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- myclg.memberdetail definition
CREATE TABLE `memberdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- myclg.student definition
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `memDetail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKadv49ew53m7vrltcqk7xej9n5` (`memDetail_id`),
  CONSTRAINT `FKadv49ew53m7vrltcqk7xej9n5` FOREIGN KEY (`memDetail_id`) REFERENCES `memberdetail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- myclg.student_feereceipt definition
CREATE TABLE `student_feereceipt` (
  `Student_id` int NOT NULL,
  `receiptList_id` int NOT NULL,
  UNIQUE KEY `UK_ikskfma28b0rcfc2rq9nkus8g` (`receiptList_id`),
  KEY `FKmbeovk9jskba4sbabx7mlhfyn` (`Student_id`),
  CONSTRAINT `FKet8gkx6bykpk52qfmdmn0wget` FOREIGN KEY (`receiptList_id`) REFERENCES `feereceipt` (`id`),
  CONSTRAINT `FKmbeovk9jskba4sbabx7mlhfyn` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;