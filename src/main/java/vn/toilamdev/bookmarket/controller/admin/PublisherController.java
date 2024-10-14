package vn.toilamdev.bookmarket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.service.PublisherService;

@Controller
@RequestMapping("/admin/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/create")
    public String getCreatePublisherPage() {
        return "admin/publisher/publisher-create";
    }

    @GetMapping("/update/{id}")
    public String getUpdatePublisherPage(Model model, @PathVariable long id) {
        Publisher publisher = this.publisherService.getPublisherById(id);
        model.addAttribute("currentPublisher", publisher);
        return "admin/publisher/publisher-update";
    }

    @GetMapping("/detail/{id}")
    public String getDetailPublisherPage(Model model, @PathVariable long id) {
        Publisher currentPublisher = this.publisherService.getPublisherById(id);
        model.addAttribute("currentPublisher", currentPublisher);
        return "admin/publisher/publisher-detail";
    }
}
