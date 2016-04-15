package com.piotr.controller;

import com.piotr.dao.LibraryDao;

import com.piotr.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by jalos on 05.04.2016.
 */
//todo nr 4 strona CreateLibraryServlet
@Controller
public class LibraryController {

    @Autowired
    private LibraryDao libraryDao;

    @RequestMapping(value = "/librariesListServletMapping", method = RequestMethod.GET)
    public String getLibraryListView(Model model) throws SQLException {
        List<Library> libraries = libraryDao.findAll();
        model.addAttribute("librariesLoop", libraries);
        return "library-list";
    }

    @RequestMapping(value = "/library-create", method = RequestMethod.GET)
    public String getCreateLibraryView() {
        return "library-create";
    }

    @RequestMapping(value = "/library-create", method = RequestMethod.POST)
    public String create(@RequestParam(value = "autor") String autor,
                         @RequestParam(value = "tytul") String tytul,
                         @RequestParam(value = "ISBN") String ISBN,
                         @RequestParam(value = "data_usuniecia") Integer data_usuniecia,
                         @RequestParam(value = "data_rejestracji") Integer data_rejestracji) throws SQLException {

        Library library = new Library(data_rejestracji, data_usuniecia, autor, ISBN, tytul);
        libraryDao.save(library);

        return "redirect:/librariesListServletMapping";
    }


    @RequestMapping(value = "/library-edit", method = RequestMethod.GET)
    public String getLibraryEdit(Model model,
                                 @RequestParam(value = "id") Integer id) throws SQLException {


        Library library = libraryDao.findById(id);
        model.addAttribute("library", library);
        return "library-edit";


    }

    @RequestMapping(value = "/library-edit", method = RequestMethod.POST)
    public String update(@RequestParam(value = "autor") String autor,
                         @RequestParam(value = "tytul") String tytul,
                         @RequestParam(value = "ISBN") String ISBN,
                         @RequestParam(value = "id") Integer id,
                         @RequestParam(value = "data_usuniecia") Integer data_usuniecia,
                         @RequestParam(value = "data_rejestracji") Integer data_rejestracji) throws SQLException {


        Library library = new Library(data_rejestracji, data_usuniecia, id, autor, ISBN, tytul);
        libraryDao.update(library);
        return "redirect:/librariesListServletMapping";
    }

    @RequestMapping(value = "/deleteLibraryAction", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") Integer id) throws SQLException {

        libraryDao.deleteById(id);
        return "redirect:/librariesListServletMapping";
    }
}


//This String will be interpreted by Spring MVC as the name of the view that
//will be rendered. DispatcherServlet will ask the view resolver to resolve this logical
//      view name into an actual view.