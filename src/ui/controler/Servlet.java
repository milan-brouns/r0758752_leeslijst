package ui.controler;

import model.DB.LeesLijst;
import model.domain.Boek;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    LeesLijst leesLijst = new LeesLijst();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String command = "";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        String destination;
        switch (command){
            case "overzicht":
                destination =overview(request,response);
                break;
            case "voegToe":
                destination =voegToe(request,response);
                break;
            case "verwijder":
                destination = verwijderRequest(request,response);
                break;
            case "zeker":
                destination =verwijderDefinitief(request,response);
                break;
            case "zoek":
                destination =zoek(request,response);
                break;
            default:
                destination=home(request,response);

        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request,response);
    }

    private String overview(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("boekenLijst",leesLijst.getBoekenlijst());
        return "overzicht.jsp";
    }

    private String voegToe (HttpServletRequest request,HttpServletResponse response){
        String titel = request.getParameter("titel");
        String auteur = request.getParameter("auteur");
        int aantalPaginas = Integer.parseInt(request.getParameter("aantalPaginas"));
        if (titel.trim().isEmpty()||auteur.trim().isEmpty()|| aantalPaginas<1){
            String error = "U vulde niet alle velden corect in.";
            request.setAttribute("error",error);
            return "voegToe.jsp";
        }else {
            Boek boek = new Boek(titel, auteur, aantalPaginas);
            if (leesLijst.getBoekenlijst().contains(boek)){
                String error = "je hebt al een boek met deze titel op je leesijst staan.";
                request.setAttribute("error",error);
                return "voegToe.jsp";
            }else {
                leesLijst.voegBoekToe(boek);
                request.setAttribute("boekenLijst", leesLijst.getBoekenlijst());
                return "overzicht.jsp";
            }
        }
    }

    private String verwijderRequest(HttpServletRequest request,HttpServletResponse response){
        return "verwijderBevesteging.jsp";
    }
    private String verwijderDefinitief(HttpServletRequest request,HttpServletResponse response){
        Boek boek = leesLijst.zoekBoek(request.getParameter("titel"));
        leesLijst.verwijder(boek);
        return overview(request,response);
    }

    private String zoek(HttpServletRequest request,HttpServletResponse response){
        Boek boek =leesLijst.zoekBoek(request.getParameter("titel"));
        if (boek == null){
            return "nietGevonden.jsp";
        }else {
            request.setAttribute("boek",boek);
            return "gevonden.jsp";
        }
    }

    private String home(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("dunste",leesLijst.getDunsteBoek());
        request.setAttribute("dikste",leesLijst.getDiksteBoek());
        return  "index.jsp";
    }
}
