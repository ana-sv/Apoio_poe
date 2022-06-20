package pt.isec.pa.apoio_poe.model.data;

import java.util.*;
import java.util.stream.Collectors;

public class Data {

    protected HashMap<Long, Aluno> listaAlunos; // numEstudante, Aluno

    protected HashMap<String, Docente> listaDocentes; // mail , Docente
    protected HashMap<String, Proposta> listaPropostas; // codigoProp , Proposta
    protected HashMap<Long, Candidatura> listaCandidaturas; // numAluno Candidatura

    protected HashMap<Long, String> listaFinal; // numAluno , codigo Proposta atribuida

    protected ArrayList<Boolean> situacaoEstados; // true se o estado está aberto, false se está fechado/bloqueado

    public Data() {
        this.listaAlunos = new HashMap<>();
        this.listaDocentes = new HashMap<>();
        this.listaPropostas = new HashMap<>();
        this.listaCandidaturas = new HashMap<>();
        this.situacaoEstados = new ArrayList<>();

        for (int i = 0; i < 5; i++) { // porque são 4 fases, uma posicao para cada um
            situacaoEstados.add(true);
        }
    
    }



    // https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
    public void sortByClassification() {

        HashMap<Long, Aluno> temp = listaAlunos.entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getValue().compareTo(
                        i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        this.listaAlunos = temp; // funciona?
    }

    public String mostraListas() {

        StringBuilder s = new StringBuilder();

        s.append("\n> Lista Alunos ");
        for (Aluno a : listaAlunos.values()) {
            s.append(a.alunoToString());
        }
        s.append("\n");

        s.append("\n> Lista Docentes ");
        for (Docente a : listaDocentes.values()) {
            s.append(a.DocentesToString());
        }
        s.append("\n");

        s.append("\n> Lista Propostas ");
        for (Proposta a : listaPropostas.values()) {
            s.append(a.propostasToString());
        }
        s.append("\n");

        return s.toString();
    }

    public String mostraListasAlunos() {

        StringBuilder s = new StringBuilder();

        s.append("\n> Lista Alunos ");
        for (Aluno a : listaAlunos.values()) {
            s.append(a.alunoToString());
        }

        return s.toString();
    }

    public String mostraListaDocentes() {

        StringBuilder s = new StringBuilder();
        s.append("\n> Lista Docentes ");
        for (Docente a : listaDocentes.values()) {
            s.append(a.DocentesToString());
        }
        s.append("\n");

        return s.toString();
    }

    public String mostraListaPropostas() {

        StringBuilder s = new StringBuilder();

        s.append("\n> Lista Propostas ");
        for (Proposta a : listaPropostas.values()) {
            s.append(a.propostasToString());
        }
        s.append("\n");

        return s.toString();
    }

    public String mostraListaCandidaturas() {

        StringBuilder s = new StringBuilder();

        s.append("\n> Lista Candidaturas ");
        for (Candidatura a : listaCandidaturas.values()) {
            s.append(a.candidaturaToString());
        }
        s.append("\n");

        return s.toString();
    }

    public Boolean getSituacaoEstados(int i) {
        return situacaoEstados.get(i);
    }

    public void setSituacaoEstados(int i, boolean x) {
        situacaoEstados.set(i, x);
    }

    public String infoCandidaturasToString(Boolean comOrientador) {
        StringBuilder str = new StringBuilder();

        return str.toString();
    }

    public HashMap<Long, Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public ArrayList<Aluno> getArrayAlunos() {

        return listaAlunos.values().stream().collect(Collectors.toCollection(ArrayList::new));

    }

    public ArrayList<Docente> getArrayDocentes(){
        return listaDocentes.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Proposta> getArrayPropostas(){
        return listaPropostas.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public HashMap<String, Docente> getListaDocentes() {
        return listaDocentes;
    }

    public HashMap<String, Proposta> getListaProposta() {
        return listaPropostas;
    }

    public HashMap<Long, Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }

    public HashMap<Long, String> getListaFinal() {
        return listaFinal;
    }

    public boolean alunoExiste(String email) {
        for (Aluno s : listaAlunos.values()) {
            if (email.equals(s.getMail()))
                return true;
        }
        return false;
    }

    public boolean alunoExiste(long numeroAluno) {
        return listaAlunos.containsKey(numeroAluno);
    }

    public boolean alunoExisteListaFinal(long numeroAluno) {
        return listaFinal.containsKey(numeroAluno);
    }

    public boolean docenteExiste(String email) {
        return listaDocentes.containsKey(email);
    }

    public boolean propostaExiste(String codigo) {
        return listaPropostas.containsKey(codigo);
    }

    public void adicionaAluno(long numeroAluno, String nome, String mail, String curso, String ramo,
            Double classificacao, Boolean estagioAcesso) {
        listaAlunos.put(numeroAluno, new Aluno(numeroAluno, nome, mail, curso, ramo, classificacao, estagioAcesso));
    }

    public void adicionaDocente(String nome, String mail) {
        listaDocentes.put(mail, new Docente(nome, mail));
    }

    public void adicionaEstagio(String codigoProp, String area, String titulo, String entidadeAcolhimento) {
        listaPropostas.put(codigoProp, new Estagio(codigoProp, area, titulo, entidadeAcolhimento));
    }

    public void adicionaProjecto(String codigoProp, String area, String titulo, String mail, Long numEstudante) {
        listaPropostas.put(codigoProp, new Projeto(codigoProp, area, titulo, mail, numEstudante));
    }

    public void adicionaAutoProposta(String codigoProp, String titulo, Long numEstudante) {
        listaPropostas.put(codigoProp, new AutoProposta(codigoProp, titulo, numEstudante));
    }

    public void adicionaCandidatura(Long numEstudante, ArrayList<String> lista) {
        listaCandidaturas.put(numEstudante, new Candidatura(numEstudante, lista));
    }

    public Integer contaAlunos() {
        return this.listaAlunos.size();
    }

    public Integer contaDocentes() {
        return this.listaDocentes.size();
    }

    public Integer contaPropostas() {
        return this.listaPropostas.size();
    }

    public Integer contaPropostasDA() {
        int n = Collections.frequency(listaPropostas.values(), new Estagio("DA"));
        n = +Collections.frequency(listaPropostas.values(), new Projeto("DA"));
        return n;

    }

    public Integer contaPropostasSI() {
        int n = Collections.frequency(listaPropostas.values(), new Estagio("SI"));
        n = +Collections.frequency(listaPropostas.values(), new Projeto("SI"));
        return n;

    }

    public Integer contaPropostasRAS() {
        int n = Collections.frequency(listaPropostas.values(), new Estagio("RAS"));
        n = +Collections.frequency(listaPropostas.values(), new Projeto("RAS"));
        return n;

    }

}
