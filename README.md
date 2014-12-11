stream-life
===========

[![Build Status](https://travis-ci.org/mkrogemann/stream-life.svg?branch=master)](https://travis-ci.org/mkrogemann/stream-life)

The solution is very slow at this point, simply because streaming through the whole universe for each Cell cannot be the fastest
way to do it. So what's required is a more intelligent data structure or a way to efficiently build sub streams for the neighborhoods
of each Cell.

Using parallelStream() vs. stream() displays expected behaviour: All cores are busy when using parallelStream().
