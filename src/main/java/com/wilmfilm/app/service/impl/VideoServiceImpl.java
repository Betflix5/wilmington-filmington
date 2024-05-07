package com.wilmfilm.app.service.impl;

import com.wilmfilm.app.domain.Video;
import com.wilmfilm.app.repository.VideoRepository;
import com.wilmfilm.app.service.VideoService;
import com.wilmfilm.app.service.dto.VideoDTO;
import com.wilmfilm.app.service.mapper.VideoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.wilmfilm.app.domain.Video}.
 */
@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    private final Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);

    private final VideoRepository videoRepository;

    private final VideoMapper videoMapper;

    public VideoServiceImpl(VideoRepository videoRepository, VideoMapper videoMapper) {
        this.videoRepository = videoRepository;
        this.videoMapper = videoMapper;
    }

    @Override
    public VideoDTO save(VideoDTO videoDTO) {
        log.debug("Request to save Video : {}", videoDTO);
        Video video = videoMapper.toEntity(videoDTO);
        video = videoRepository.save(video);
        return videoMapper.toDto(video);
    }

    @Override
    public VideoDTO update(VideoDTO videoDTO) {
        log.debug("Request to update Video : {}", videoDTO);
        Video video = videoMapper.toEntity(videoDTO);
        video = videoRepository.save(video);
        return videoMapper.toDto(video);
    }

    @Override
    public Optional<VideoDTO> partialUpdate(VideoDTO videoDTO) {
        log.debug("Request to partially update Video : {}", videoDTO);

        return videoRepository
            .findById(videoDTO.getId())
            .map(existingVideo -> {
                videoMapper.partialUpdate(existingVideo, videoDTO);

                return existingVideo;
            })
            .map(videoRepository::save)
            .map(videoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<VideoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Videos");
        return videoRepository.findAll(pageable).map(videoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VideoDTO> findOne(Long id) {
        log.debug("Request to get Video : {}", id);
        return videoRepository.findById(id).map(videoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Video : {}", id);
        videoRepository.deleteById(id);
    }
}
