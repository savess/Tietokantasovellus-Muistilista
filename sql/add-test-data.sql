INSERT INTO kayttaja (tunnus, nimi, salasana) VALUES
    (1001, 'joku', 'salasana');
INSERT INTO tarkeys (arvo, kid, selite) VALUES
    (1, (select kid from kayttaja where tunnus = '1001'), 'erittäin tärkeä');
INSERT INTO askare (nimi, kid, tid) VALUES
    ('imuroi', (select kid from kayttaja where tunnus = '1001'), (select tid from tarkeys a, kayttaja b where b.tunnus = '1001' and a.kid= b.kid));

INSERT INTO luokka (nimi, kid) VALUES
    ('koti', (select kid from kayttaja where tunnus = '1001'));

INSERT INTO askareenluokka (kid, lid) VALUES
    ((select kid from kayttaja where tunnus = '1001'), (select lid from luokka a, kayttaja b where b.tunnus = '1001' and a.kid = b.kid));
