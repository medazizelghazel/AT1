package bibliotheque;

/**
 * JUSTIFICATION : exceptions CHECKED.
 * Un document indisponible ou introuvable est une situation métier normale
 * et récupérable (proposer une réservation, un autre titre). Le compilateur
 * force l'appelant à décider quoi faire. Les erreurs de programmation
 * (null, état incohérent) restent unchecked.
 * Inconvénient : signatures alourdies par les "throws".
 */

public class MediathequeException extends Exception {
    protected MediathequeException(String message) { super(message); }
    protected MediathequeException(String message, Throwable cause) { super(message, cause); }
}
