package pl.webApplication.shop.tag.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pl.webApplication.shop.tag.model.Tag;
import pl.webApplication.shop.tag.repository.TagRepository;

import java.util.List;

@Service
public class TagService  {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag getTagById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tag not found"));
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag updateTag(Long id, Tag tag) {
        tagRepository.save(tag);
        return tag;
    }

    public boolean deleteTag(Long id) {
        tagRepository.deleteById(id);
        return false;
    }

    public List<Tag> getTagsByProductId(Long productId) {
        return tagRepository.findByProducts_Id(productId);
    }
}

