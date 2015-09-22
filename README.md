stream-life
===========

[![Build Status](https://travis-ci.org/mkrogemann/stream-life.svg?branch=master)](https://travis-ci.org/mkrogemann/stream-life)

Why would you implement Game of Life based on Java streams? Well, you would not.

The solution is very slow, simply because streaming through the whole universe for each Cell cannot be the fastest
way to do it.

This code rather represents a stubborn, somewhat stupid idea.

One learning though: Using parallelStream() vs. stream() displays expected behaviour: All cores are busy when using parallelStream().
