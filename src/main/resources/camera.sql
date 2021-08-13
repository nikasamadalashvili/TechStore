
CREATE TABLE `camera` (
  `cameraID` bigint NOT NULL,
  `number_of_camera` int DEFAULT NULL,
  `main_camera_mp` varchar(64) DEFAULT NULL,
  `second_camera_mp` varchar(64) DEFAULT NULL,
  `third_camera_mp` varchar(64) DEFAULT NULL,
  `forth_camera_mp` varchar(64) DEFAULT NULL,
  `video_resolution` varchar(64) DEFAULT NULL,
  `autofocus` varchar(64) DEFAULT NULL,
  `lighting` varchar(64) DEFAULT NULL,
  `aperture` varchar(64) DEFAULT NULL,
  `hdr` varchar(64) DEFAULT NULL,
  `panorama` varchar(64) DEFAULT NULL,
  `selfie_camera` varchar(64) DEFAULT NULL,
  `selfie_video_resolution` varchar(64) DEFAULT NULL,
  `selfie_autofocus` varchar(64) DEFAULT NULL,
  `selfie_hdr` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`cameraID`)
);