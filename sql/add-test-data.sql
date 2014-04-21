INSERT INTO kayttaja (tunnus, nimi, salasana) VALUES
    ('annaa', 'Anna A', 'salasana');
INSERT INTO kayttaja (tunnus, nimi, salasana) VALUES
    ('onnio','Onni O' , 'salasana');
INSERT INTO tarkeys (arvo, kid, selite) VALUES
    (1, (select kid from kayttaja where tunnus = 'onnio'), 'Tarkea');
INSERT INTO luokka (nimi, kid) VALUES
    ('koti', (select kid from kayttaja where tunnus = 'onnio'));
INSERT INTO luokka (nimi, kid) VALUES
   ('harrastus' (select kid from kayttaja where tunnus = 'annaa'));

INSERT INTO askare (nimi, kid, tid,lid) VALUES
    ('imuroi', (select kid from kayttaja where tunnus = 'onnio'), (select tid from tarkeys where selite = 'Tarkea'),(select lid from luokka where nimi = 'koti' limit 1));

INSERT INTO askare (nimi, kid, tid,lid) VALUES
  ('valokuvaa kevat' , (select kid from kayttaja where tunnus = 'onnio'),(select tid from tarkeys where selite = 'Heti'),(select lid from luokka where nimi ='harrastus');
