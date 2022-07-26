
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

import Utilisateur from '../models/utilisateur.model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {


  private apiUrl = 'http://localhost:8080';



  constructor(private httpClient: HttpClient) { }



  getUtilisateurs(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(`${this.apiUrl}/Utilisateur`);
  }

  getUtilisateur(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(`${this.apiUrl}/Utilisateur/${id}`);

  }
  createUtilisateur(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.post<Utilisateur>(`${this.apiUrl}/Utilisateur`, utilisateur);
  }

  deleteUtilisateur(id: number): Observable<Utilisateur> {
    return this.httpClient.delete<Utilisateur>(`${this.apiUrl}/Utilisateur/${id}`);
  }

  updateUtilisateur(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.put<Utilisateur>(`${this.apiUrl}/Utilisateur/${utilisateur.id}`, utilisateur);
  }


}
