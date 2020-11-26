package ui.controler;

import model.DB.LeesLijst;
import model.domain.Boek;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    LeesLijst leesLijst = new LeesLijst();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch (command) {
            case "overzicht":
                destination = overview(request, response);
                break;
            case "voegToe":
                destination = voegToe(request, response);
                break;
            case "verwijder":
                destination = verwijderRequest(request, response);
                break;
            case "zeker":
                destination = verwijderDefinitief(request, response);
                break;
            case "zoek":
                destination = zoek(request, response);
                break;
            case "setMinimumDikte":
                destination = setMinimumdikte(request, response);
                break;
            default:
                destination = home(request, response);

        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("boekenLijst", leesLijst.getBoekenlijst());
        return "overzicht.jsp";
    }

    private String voegToe(HttpServletRequest request, HttpServletResponse response) {
        Boek boek = new Boek();
        ArrayList<String> errors = new ArrayList<>();

        setTitel(request, boek, errors);
        setAuteur(request, boek, errors);
        setAantalPaginas(request, boek, errors);

        if (errors.size() == 0) {
            try {
                leesLijst.voegBoekToe(boek);
                return overview(request, response);
            } catch (IllegalArgumentException exc) {
                errors.add(exc.getMessage());
                request.setAttribute("errors", errors);
                return "voegToe.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "voegToe.jsp";
        }

    }
//setters voor add methode

    private void setTitel(HttpServletRequest request, Boek boek, ArrayList<String> errors) {
        try {
            boek.setTitel(request.getParameter("titel"));
            request.setAttribute("titelClass", "has-success");
            request.setAttribute("titelPreviousValue", request.getParameter("titel"));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("titelClass", "has-error");
        }
    }

    private void setAuteur(HttpServletRequest request, Boek boek, ArrayList<String> errors) {
        try {
            boek.setAuteur(request.getParameter("auteur"));
            request.setAttribute("auteurClass", "has-success");
            request.setAttribute("auteurPreviousValue", request.getParameter("auteur"));
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("auteurClass", "has-error");
        }
    }

    private void setAantalPaginas(HttpServletRequest request, Boek boek, ArrayList<String> errors) {
        try {
            boek.setAantalpaginas(Integer.parseInt(request.getParameter("aantalPaginas")));
            request.setAttribute("aantalPaginasClass", "has-success");
            request.setAttribute("aantalPaginasPreviousValue", request.getParameter("aantalPaginas"));
        } catch (NumberFormatException exc) {
            errors.add("het aantal paginas kan enkel cijfers bevatten.");
            request.setAttribute("aantalPaginasClass", "has-error");
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("aantalPaginasClass", "has-error");
        }
    }
//einde setters

    private String verwijderRequest(HttpServletRequest request, HttpServletResponse response) {
        return "verwijderBevesteging.jsp";
    }

    private String verwijderDefinitief(HttpServletRequest request, HttpServletResponse response) {
        leesLijst.verwijder(request.getParameter("titel"));
        return overview(request, response);
    }

    private String zoek(HttpServletRequest request, HttpServletResponse response) {
        Boek boek = leesLijst.zoekBoek(request.getParameter("titel"));
        if (boek == null) {
            return "nietGevonden.jsp";
        } else {
            request.setAttribute("boek", boek);
            return "gevonden.jsp";
        }
    }

    private String setMinimumdikte(HttpServletRequest request, HttpServletResponse response) {
        //form validatie + cookie maken en in respons setten
        ArrayList<String> errors = new ArrayList<>();
        try {
            int minimumDikte = Integer.parseInt(request.getParameter("minimumDikte"));
            if (minimumDikte < 5) throw new IllegalArgumentException("kies een getal groter dan '5'");
            request.setAttribute("minimumDikteClass", "has-success");
            Cookie cookie = new Cookie("minimunDikte", Integer.toString(minimumDikte));
            response.addCookie(cookie);
            request.setAttribute("vorigeMinimumDikte", minimumDikte);
        } catch (NumberFormatException exc) {
            errors.add("het invul veld kan enkel cijfers bevatten.");
            request.setAttribute("minimumDikteClass", "has-error");
        } catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("minimumDikteClass", "has-error");
        }
        request.setAttribute("errors", errors);
        //einde validatie
        return home(request, response);
    }

    private int getminimumDikteCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("minimunDikte")) {
                return Integer.parseInt(cookie.getValue());
            }
        }
        return -1;
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        int minimumDikte = 5;
        if (getminimumDikteCookie(request) > 5) {
            minimumDikte = getminimumDikteCookie(request);
            request.setAttribute("vorigeMinimumDikte", minimumDikte);
        } else if (request.getAttribute("vorigeMinimumDikte") != null) {
            minimumDikte = Integer.parseInt(request.getAttribute("vorigeMinimumDikte").toString());
        }

        if (leesLijst.getDunsteBoek(minimumDikte) != null) {
            request.setAttribute("dunste", leesLijst.getDunsteBoek(minimumDikte));
        } else {
            request.setAttribute("dunste", "er is geen boek in de lees lijst met meer pagina's dan je opgegeven waarde.");
        }
        if (leesLijst.getDunsteBoek(minimumDikte) != null) {
            request.setAttribute("dikste", leesLijst.getDiksteBoek(minimumDikte));
        } else {
            request.setAttribute("dikste", "er is geen boek in de lees lijst met meer pagina's dan je opgegeven waarde.");
        }
        return "index.jsp";
    }

}
