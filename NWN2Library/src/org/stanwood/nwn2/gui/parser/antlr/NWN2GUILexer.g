lexer grammar NWN2GUILexer;

@header 
{ package org.stanwood.nwn2.gui.parser.antlr; 
/*
 *  Copyright (C) 2008  John-Paul.Stanford <dev@stanwood.org.uk>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */}

@members {
    boolean tagMode = false;
    boolean prologMode = false;
    boolean commentMode = false;
}

COMMENT_START : '<!' { commentMode = true; } ;
COMMENT_END : { commentMode }?=> '>' { commentMode = false; } ;
PROLOG_START : '<?' { prologMode = true; } ;
PROLOG_END : { prologMode }?=> '>' { prologMode = false; } ;
TAG_START_OPEN : { !prologMode && !commentMode }?=> '<' { tagMode = true; } ;
TAG_END_OPEN : { !prologMode && !commentMode }?=> '</' { tagMode = true; } ;
TAG_CLOSE : { tagMode }?=> '>' { tagMode = false; } ;
TAG_EMPTY_CLOSE : { tagMode }?=> '/>' { tagMode = false; } ;

COMMENT : { commentMode }?=> (~'>')+ ;

ATTR_EQ : { tagMode }?=> '=' ;
    
GENERIC_ID
    : { tagMode }?=>
      (NAMECHAR | '\\' |'"' | '\'' | ',' | '('| ')' )* ~( '>' | '/' | '=' | ' ' | '\r'|'\t'|'\u000C'|'\n' )
    ;

PROLOG : { prologMode }?=> (~'>')+ ;  

PCDATA : { !prologMode && !tagMode && !commentMode }?=> (~'<')+ ;

fragment NAMECHAR
    : LETTER | DIGIT | '.' | '-' | '_' | ':' 
    ;

fragment DIGIT
    :    '0'..'9'
    ;

fragment LETTER
    : 'a'..'z'
    | 'A'..'Z'
    ;   

WS  :  { tagMode }?=>
       (' ' | '\r'|'\t'|'\u000C'|'\n') { skip(); }
    ;
